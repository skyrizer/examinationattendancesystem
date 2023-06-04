package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;

@Controller
public class AttendanceMenuController {

	private String defaultURI = "http://localhost:8080/examinationattendancesystem/api/attend";
	
	/**
	 * This method will add an attendance
	 * 
	 * @param examinationAttendance
	 * @return
	 */
	@RequestMapping("/examinationattendance/save")
	public String updateOrderType(@ModelAttribute ExaminationAttendance examinationAttendance)
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
		return "redirect:";
	}

}
