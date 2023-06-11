package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationUnit;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Subject;

@Controller
public class AttendanceMenuController {

	private String defaultURI = "http://localhost:8080/examinationattendancesystem/api/attend";

	@GetMapping("/attendance/list")
	public String getAttendances(Model model)
	{
		// The URI for GET attendance
		String uri = "http://localhost:8080/examinationattendancesystem/api/attend";
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ExaminationAttendance[]> response = restTemplate.getForEntity(uri, ExaminationAttendance[].class);
		
		// Parse JSON data to array of object
		ExaminationAttendance attendance[] = response.getBody();
		
		// Parse an array to a list object
		List<ExaminationAttendance> attendanceList = Arrays.asList(attendance);
		
		// Attach list to model as attribute
		model.addAttribute("attendance", attendanceList);
		
		return "attends";
	}
	
	/**
	 * This method will add an attendance
	 * Author : Hafiz Suhaizal
	 * @param examinationAttendance
	 * @return
	 */
	@RequestMapping("/examinationAttendance")
	public String recordAttendance(@ModelAttribute ExaminationAttendance examinationAttendance)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<ExaminationAttendance> request =new HttpEntity<ExaminationAttendance>(examinationAttendance);
		
		String examinationAttendanceResponse = " ";
		
			// This block add a new order type
			
			// send request as POST
			examinationAttendanceResponse = restTemplate.postForObject(
					defaultURI, request, String.class);
		
		
		System.out.println(examinationAttendanceResponse);
		
		return "redirect:/attendance/list";
	
	}

	
	/**
	 * This method gets an order type
	 * 
	 * @param ExamAttendId
	 * @param model
	 * @return
	 */
	@GetMapping("/attendance/{ExamAttendId}")
	public String getOrderType (@PathVariable Integer ExamAttendId, Model model) {
		
		String pageTitle = "New Order Type";
		ExaminationAttendance ExaminationAttendance = new ExaminationAttendance();
		
		// This block get an order type to be updated
		if (ExamAttendId > 0) {

			// Generate new URI and append orderTypeId to it
			String uri = defaultURI + "/" + ExaminationAttendance;
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			ExaminationAttendance = restTemplate.getForObject(uri, ExaminationAttendance.class);
			
			//Give a new title to the page
			pageTitle = "Edit";
		}
		
		// Attach value to pass to front end
		model.addAttribute("Edit", ExaminationAttendance);
		model.addAttribute("test", pageTitle);
		
		return "examinationAttendance";
			
	}
	
	
	/**
	 * This method will add an attendance
	 * Author : Hafiz Suhaizal
	 * @param examinationAttendance
	 * @return
	 */
	/*
	@RequestMapping("/examinationAttendance")
	public String recordAttendance(@ModelAttribute ExaminationAttendance examinationAttendance)
	{
	    // Create a new RestTemplate
	    RestTemplate restTemplate = new RestTemplate();

	    // Assuming you have a method in your AttendanceRESTController to retrieve a student by matric number
	    // Create the URI for retrieving the student by matric number
	    String studentURI = "http://localhost:8080/examinationattendancesystem/api/students/" + examinationAttendance.getStudentId().getStudentMatricNo();

	    // Get the student from the web service
	    Student student = restTemplate.getForObject(studentURI, Student.class);

	    // Set the StudentId in the ExaminationAttendance object with the retrieved student
	    examinationAttendance.setStudentId(student);

	    // Create request body
	    HttpEntity<ExaminationAttendance> request = new HttpEntity<ExaminationAttendance>(examinationAttendance);

	    String examinationAttendanceResponse = "";

	    // This block adds a new order type
	    // send request as POST
	    examinationAttendanceResponse = restTemplate.postForObject(defaultURI, request, String.class);

	    System.out.println(examinationAttendanceResponse);

	    // Redirect request to display a list of order type
	    return "redirect:/attendance/list";
	}

*/
	/*
	 * For attendance by Venue
	 * 
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
		// The URI for GET order types
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ExaminationAttendance[]> response = restTemplate.getForEntity(uri, ExaminationAttendance[].class);
		
		// Parse JSON data to array of object
		ExaminationAttendance attendanceVenue[] = response.getBody();
		
		/*
		 * System.out.println(this.getClass().getSimpleName() + " @ 41 length = " +
		 * examination.length); System.out.println(this.getClass().getSimpleName() +
		 * " @ 42"); for (Examination currentExam:examination) {
		 * 
		 * System.out.println("Examination Id  " + currentExam.getExaminationId());
		 * System.out.println("Unit name " + currentExam.getUnit().getUnitName());
		 * System.out.println("Subject name" +
		 * currentExam.getSubject().getSubjectName()); }
		 */
		System.out.println();
		
		// Parse an array to a list object
		List<ExaminationAttendance> attendVenueList = Arrays.asList(attendanceVenue);
		
		// Attach list to model as attribute
		model.addAttribute("attendVenue", attendVenueList);
		
		// return an HTML file, Attendance.html, to the browser
		return "AttendanceVenue";
	}
}
