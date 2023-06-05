package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ExaminationMenuController {

	/*
	 * This returns a list of schedule in a table on the webpage
	 */
	@GetMapping("/examschedule/list")
	public String getOrderTypes(Model model)
	{
		// The URI for GET order types
		String uri = "http://localhost:8080/orderapp/api/ordertypes";
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object[]> response = restTemplate.getForEntity(uri, Object[].class);
		
		// Parse JSON data to array of object
		Object objExam[] = response.getBody();
		
		// Parse an array to a list object
		List<Object> objExamList = Arrays.asList(objExam);
		
		// Attach list to model as attribute
		model.addAttribute("ExamsList", objExamList);
		
		return "ExamsList";
		
	}
}
