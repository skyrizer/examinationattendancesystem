package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;

@Controller
public class AttendanceMenuController {

	private String defaultURI = "http://localhost:8080/examinationattendancesystem/api/attend";

	/**
	 * This method will add an attendance
	 * Author : Hafiz Suhaizal
	 * @param examinationAttendance
	 * @return
	 */
	@RequestMapping("/examinationattendance/save")
	public String insertOrderType(@ModelAttribute ExaminationAttendance examinationAttendance)
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
		
		// Redirect request to display a list of order type
		//ni nnti tukarrr pegi next
		return "redirect:/attendance/list";
	}

	
	/*
	 * This method will retrieve all the attendance within certain subject
	 * Author : Ng Wei Hen
	 * @param examinationAttendance
	 * @return
	 */
	@GetMapping("/attendance/list")
	public String getAttendance(Model model)
	{
		// The URI for GET attendance
		String uri = "http://localhost:8080/examinationattendance/api/attends";
		
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
}
