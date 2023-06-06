package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationUnit;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Subject;

@Controller
public class AttendanceMenuController {

	private String defaultURI = "http://localhost:8080/examinationattendancesystem/api/attend";

	/**
	 * This method will add an attendance
	 * Author : Hafiz Suhaizal
	 * @param examinationAttendance
	 * @return
	 */
	@RequestMapping("/examinationAttendance")
	public void recordAttendance(@ModelAttribute ExaminationAttendance examinationAttendance)
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
		//return "redirect:/attendance/list";
	}


	
	
	@GetMapping("/attendance/list")
	public String getAttendance(Model model)
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
}
