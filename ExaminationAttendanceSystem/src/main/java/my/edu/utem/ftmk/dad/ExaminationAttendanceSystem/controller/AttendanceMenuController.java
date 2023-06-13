package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.Arrays;
import java.util.List;

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

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationUnit;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;


@Controller
public class AttendanceMenuController {

	private String defaultURI = "http://localhost:8080/examinationattendancesystem/api/attend";

	/**
	 *This method is to get an attendance list
	 *Author: Hafiz Suhaizal
	 *
	 */
	@GetMapping("/attendance/list")
	public String getAttendance(Model model)
	{
		// The URI for GET attendance
		String uri = "http://localhost:8080/examinationattendancesystem/api/attend";

		//Get a list of attendance from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ExaminationAttendance[]> response = restTemplate.getForEntity(uri, ExaminationAttendance[].class);

		// Parse JSON data to array of object
		ExaminationAttendance examinationAttendance[] = response.getBody();

		// Parse an array to a list object
		List<ExaminationAttendance> examinationAttendanceList = Arrays.asList(examinationAttendance);

		// Attach list to model as attribute
		model.addAttribute("examinationAttendance", examinationAttendanceList);


		//return an HTML file, attendancelist.html, to the browser
		return "attendancelist";


	}

	/**
	 * This method will update or add an attendance.
	 * Author :Hafiz Suhaizal 
	 * @param examinationAttendance
	 * @return
	 */
	@RequestMapping("/examinationattendance/save")
	public String updateExaminationAttendance(@ModelAttribute ExaminationAttendance examinationAttendance)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		// Create request body
		HttpEntity<ExaminationAttendance> request =new HttpEntity<ExaminationAttendance>(examinationAttendance);

		String attendanceResponse = " ";

		// This block add a new attendance
		// send request as POST
		attendanceResponse = restTemplate.postForObject(
				defaultURI, request, String.class);


		// Redirect request to display a list of attendance
		return "redirect:/attendance/list";
	}

	/**
	 * This method gets an examination attendance id
	 * Author :Hafiz Suhaizal
	 * @param examinationId
	 * @param model
	 * @return
	 */
	@GetMapping("/examinationattendance/{examinationId}")
	public String getExaminationAttendance (@PathVariable Integer examinationId, Model model,
			@RequestParam(name = "matricNo",required=false) String matricNo) {

		String pageTitle = "New Attendance";
		ExaminationAttendance examinationAttendance = new ExaminationAttendance();
		examinationAttendance.getExamination().setExaminationId(examinationId);

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
		//return an HTML file, examinationattendance.html, to the browser

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
	public String getAttendanceVenueTypes(Model model,@RequestParam(name = "unitid",required = false) String unitId)
	{ 
		String uri = "http://localhost:8080/examinationattendancesystem/api/attend";
		
		// filter table based on Unit Id (Examination Unit)
		if(!Strings.isBlank(unitId)) {

			try {
				int intId = Integer.parseInt(unitId); 
				
				if(intId == 0) {
					 uri = "http://localhost:8080/examinationattendancesystem/api/attend";
				}
				else {

					uri = "http://localhost:8080/examinationattendancesystem/api/attend/Venue/" + unitId;	
				} 
			}catch (Exception e) { 

			}
		}
		else {
			// default Unit Id to display all attendance based on venue
			unitId = "0";
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
		model.addAttribute("selectedUnit", Integer.parseInt( unitId));

		// return an HTML file, AttendanceVenue.html, to the browser
		return "AttendanceVenue";
	}
	/*
	 * This method display report of attendance based on subject
	 * 
	 * @author Wafir
	 * @param examinationId
	 * @param model
	 * @return
	 */
	
	@GetMapping("/report/{examinationId}")
	public String getExamination (@PathVariable Integer examinationId, Model model) {

		String pageTitle = "Report Attendance";
		

		RestTemplate restTemplateStudent = new RestTemplate();
		ResponseEntity<ExaminationAttendance[]> responseStudent = restTemplateStudent.getForEntity("http://localhost:8080/examinationattendancesystem/api/attend/report/"+ examinationId,
				ExaminationAttendance[].class);
		
		// Parse JSON data to array of examination unit
		ExaminationAttendance studentsAttendance[] = responseStudent.getBody();

		// Parse an array to a list examination unit
		List<ExaminationAttendance> studentAttendance = Arrays.asList(studentsAttendance);

		// Attach value to pass to front end
		model.addAttribute("studentAttendance", studentAttendance);
		model.addAttribute("pageTitle", pageTitle);
	
		//return an HTML file, Report.html, to the browser

		return "Report";

	}
}
