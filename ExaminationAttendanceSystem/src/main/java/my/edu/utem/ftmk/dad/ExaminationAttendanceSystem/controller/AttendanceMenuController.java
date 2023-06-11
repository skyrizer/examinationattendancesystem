package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
	 * tadi bawah ni  pakai orderType
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
		
		String orderTypeResponse = " ";
		
		if (examinationAttendance.getExamAttendId() > 0)
		{
			// This block update an new order type and
			
			// Send request as PUT
			restTemplate.put(defaultURI, request, ExaminationAttendance.class);
		}
		else
		{
			// This block add a new order type
			
			// send request as POST
			orderTypeResponse = restTemplate.postForObject(
					defaultURI, request, String.class);
		}
		
		System.out.println(orderTypeResponse);
		
		// Redirect request to display a list of order type
		return "redirect:/attendance/list";
	}

	/**
	 * This method gets an order type
	 * 
	 * @param examinationAttendanceId
	 * @param model
	 * @return
	 */
	@GetMapping("/examinationattendance/{examinationAttendanceId}")
	public String getExaminationAttendance (@PathVariable Integer examinationAttendanceId, Model model) {
		
		String pageTitle = "New Order Type";
		ExaminationAttendance examinationAttendance = new ExaminationAttendance();
		
		// This block get an order type to be updated
		if (examinationAttendanceId > 0) {

			// Generate new URI and append orderTypeId to it
			String uri = defaultURI + "/" + examinationAttendanceId;
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			examinationAttendance = restTemplate.getForObject(uri, ExaminationAttendance.class);
			
			//Give a new title to the page
			pageTitle = "Edit Order Type";
		}
		
		// Attach value to pass to front end
		model.addAttribute("examinationAttendance", examinationAttendance);
		model.addAttribute("pageTitle", pageTitle);
		//htmlfile
		
		return "examinationattendance";
			
	}
	
	/**
	 * This method deletes an order type
	 * 
	 * @param examinationAttendanceId
	 * @return
	 */
	/*@RequestMapping("/examinationattendance/delete/{examinationAttendanceId}")
	public String deleteOrderType(@PathVariable Integer orderTypeId)
	{
		// Generate new URI, similar to the mapping in OrderTypeRESTController
		String uri = defaultURI + "/{examinationAttendanceId}";
		
		// Send a DELETE request and attach the value of orderTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("examinationAttendanceId", Integer.toString(examinationAttendanceId)));
		
		return "redirect:/ordertype/list";
	}
	*/
}
