package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationUnit;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Subject;


@Controller
public class AttendanceMenuController {

	private String defaultURI = "http://localhost:8080/examinationattendancesystem/api/attend";

	@GetMapping("/attendance/list")
	public String getAttendance(Model model)
	{
		// The URI for GET order types
		String uri = "http://localhost:8080/examinationattendancesystem/api/attend";

		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ExaminationAttendance[]> response = restTemplate.getForEntity(uri, ExaminationAttendance[].class);

		// Parse JSON data to array of object
		ExaminationAttendance examinationAttendance[] = response.getBody();

		// Parse an array to a list object
		List<ExaminationAttendance> examinationAttendanceList = Arrays.asList(examinationAttendance);

		// Attach list to model as attribute
		model.addAttribute("examinationAttendance", examinationAttendanceList);


		//link to html file
		return "attendancelist";


	}

	/**
	 * This method will update or add an order type.
	 * Author :Hafiz Suhaizal 
	 * @param examinationAttendance
	 * @return
	 */
	@RequestMapping("/examinationattendance/save")
	public String updateExaminationAttendance(@ModelAttribute ExaminationAttendance examinationAttendance)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		System.out.println(examinationAttendance.getInputType());
		System.out.println(examinationAttendance.getExamination().getExaminationId());
		System.out.println(examinationAttendance.getStudentId().getStudentId());
		System.out.println(examinationAttendance.getExamAttendStatus());
		// Create request body
		HttpEntity<ExaminationAttendance> request =new HttpEntity<ExaminationAttendance>(examinationAttendance);

		String orderTypeResponse = " ";

			// This block add a new order type
			// send request as POST
			orderTypeResponse = restTemplate.postForObject(
					defaultURI, request, String.class);
		

		System.out.println(orderTypeResponse);

		// Redirect request to display a list of order type
		return "redirect:/attendance/list";
	}

	/**
	 * This method gets an order type
	 * Author :Hafiz Suhaizal
	 * @param examinationAttendanceId
	 * @param model
	 * @return
	 */
	@GetMapping("/examinationattendance/{examinationId}")
	public String getExaminationAttendance (@PathVariable Integer examinationId, Model model,
			@RequestParam(name = "matricNo",required=false) String matricNo) {

		String pageTitle = "New Attendance";
		ExaminationAttendance examinationAttendance = new ExaminationAttendance();
		examinationAttendance.getExamination().setExaminationId(examinationId);
		
		System.out.println(examinationId);
		System.out.println(examinationAttendance.getExamination().getExaminationId());

		Student currentStudent = new Student();
		if(!Strings.isBlank(matricNo)) {

			RestTemplate studentREST = new RestTemplate();
			currentStudent = studentREST.getForObject("http://localhost:8080/examinationattendancesystem/api/student/matric/"+matricNo, Student.class);
			examinationAttendance.setStudentId(currentStudent);
		} 

 

		// Attach value to pass to front end
		model.addAttribute("examinationAttendance", examinationAttendance);
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("studId", currentStudent);
		//htmlfile

		return "examinationattendance";

	}


	/*
	 * This method display the following examination attendance information
	 * based on venue.
	 * 
	 * @author Ng Wei Hen
	 * @param filterBy
	 * @param id
	 * @return
	 */
	@GetMapping("/AttendanceVenue")
	public String getAttendanceVenueTypes(Model model,@RequestParam(name = "filter",required=false) String filterBy,@RequestParam(name = "id",required = false) String id)
	{ 
		String uri = "http://localhost:8080/examinationattendancesystem/api/attend";
		System.out.println(id);
		if(!Strings.isBlank(filterBy) && ! Strings.isBlank(id)) {

			try {
				int intId = Integer.parseInt(id);

				if(filterBy.equals("Stud")) { 
					uri = "http://localhost:8080/examinationattendancesystem/api/attend";
					//pakai yg int
				}
				else if(filterBy.equals("Exam")) {

				}
			}catch (Exception e) { 

			}
		}

		// The URI for GET Examination Attendance

		//Get a list Examination Attendance from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ExaminationAttendance[]> response = restTemplate.getForEntity(uri, ExaminationAttendance[].class);

		// Parse JSON data to array of examination attendance
		ExaminationAttendance attendanceVenue[] = response.getBody();

		// Parse an array to a list object for attendance 
		List<ExaminationAttendance> attendVenueList = Arrays.asList(attendanceVenue);

		/*
		 *  The URI for GET Examination Unit for drop down menu display for examination venue
		 *	
		 */
		//Get a list Examination Unit from the web service
		RestTemplate restTemplateUnit = new RestTemplate();
		ResponseEntity<ExaminationUnit[]> responseUnit = restTemplateUnit.getForEntity("http://localhost:8080/examinationattendancesystem/api/venue",
				ExaminationUnit[].class);
		
		// Parse JSON data to array of examination unit
		ExaminationUnit unitArray[] = responseUnit.getBody();

		// Parse an array to a list examination unit
		List<ExaminationUnit> unitList = Arrays.asList(unitArray);


		// Attach list of attendance venue and examination unit to model as attribute
		model.addAttribute("attendVenue", attendVenueList);
		model.addAttribute("examUnit",unitList );

		// return an HTML file, AttendanceVenue.html, to the browser
		return "AttendanceVenue";
	}
}
