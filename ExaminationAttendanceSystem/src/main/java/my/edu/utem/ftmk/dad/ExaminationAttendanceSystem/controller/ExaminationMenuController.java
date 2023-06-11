package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.util.Strings;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;

@Controller
public class ExaminationMenuController {

	private String defaultURI = "http://localhost:8080/examinationattendancesystem/api/examination/schedule"; 
	
	// schedule/unit1
	// schedule/subject1
	// shcedule/
	// schedule/?filter=subj&id=1
	@GetMapping("/schedule")
	public String getExamTypes(Model model,@RequestParam(name = "filter",required=false) String filterBy,@RequestParam(name = "id",required = false) String id)
	{ 
		String uri = "http://localhost:8080/examinationattendancesystem/api/examination";
		System.out.println(id);
		if(!Strings.isBlank(filterBy) && ! Strings.isBlank(id)) {
			
			try {
				int intId = Integer.parseInt(id);

				if(filterBy.equals("unit")) { 
					uri = "http://localhost:8080/examinationattendancesystem/api/examination";
					//pakai yg int
				}
				else if(filterBy.equals("subj")) {
					
				}
			}catch (Exception e) { 
				
			}
		}
		// The URI for GET order types
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Examination[]> response = restTemplate.getForEntity(uri, Examination[].class);
		
		// Parse JSON data to array of object
		Examination examination[] = response.getBody();
		
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
		
		
		// Parse an array to a list object
		List<Examination> examList = Arrays.asList(examination);
		
		// Attach list to model as attribute
		model.addAttribute("Examinations", examList);
		
		// return an HTML file, schedule.html, to the browser
		return "/schedule";
	}
	
	@RequestMapping("/schedule/save")
	public String updateExamination(@ModelAttribute Examination examType)
	{
		System.out.println("test");
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println(examType.getExaminationDate());
		
		// Create request body
		HttpEntity<Examination> request =new HttpEntity<Examination>(examType);
		
		String examTypeResponse = " ";
		
		if (examType.getExaminationId() > 0)
		{
			// This block update an new order type and
			
			// Send request as PUT
			restTemplate.put("http://localhost:8080/examinationattendancesystem/api/examination", request, Examination.class);
		}
		else
		{
			// This block add a new order type
			
			// send request as POST
			examTypeResponse = restTemplate.postForObject("http://localhost:8080/examinationattendancesystem/api/examination", request, String.class);
		}
		
		System.out.println(examTypeResponse);
		
		// Redirect request to display a list of order type
		return "redirect:/schedule";
	}
	
	@GetMapping("/schedule/{ExaminationId}")
	public String getExamType (@PathVariable Integer ExaminationId, Model model) {
		
		System.out.println(ExaminationId);
		String pageTitle = "New Schedule";
		Examination examType = new Examination();
		
		// This block get an examination to be updated
		if (ExaminationId > 0) {

			// Generate new URI and append orderTypeId to it
			String uri = "http://localhost:8080/examinationattendancesystem/api/examination/" + ExaminationId;
			System.out.println(uri);
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			examType = restTemplate.getForObject(uri, Examination.class);
			
			//Give a new title to the page
			pageTitle = "Edit Schedule";
		}
		
		// Attach value to pass to front end
		model.addAttribute("examType", examType);
		model.addAttribute("pageTitle", pageTitle);
		
		return "scheduleinfo";
			
	}

	/**
	 * This method deletes an schedule
	 * 
	 * @param orderTypeId
	 * @return
	 */
	@RequestMapping("/schedule/delete/{examId}")
	public String deleteExamType(@PathVariable Integer examId)
	{
		// Generate new URI, similar to the mapping in OrderTypeRESTController
		String uri = "http://localhost:8080/examinationattendancesystem/api/examination/" + "{examId}";
		
		// Send a DELETE request and attach the value of orderTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("examId", Integer.toString(examId)));
		
		return "redirect:/schedule";
	}
	
	
	/*
	@GetMapping("/schedule")
	public String getExamTypes(Model model)
	{
		// The URI for GET order types
		String uri = "http://localhost:8080/examinationattendancesystem/api/examination";
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object[]> response = restTemplate.getForEntity(uri, Object[].class);
		
		// Parse JSON data to array of object
		Object examination[] = response.getBody();
		
		// Parse an array to a list object
		List<Object> examList = Arrays.asList(examination);
		
		// Attach list to model as attribute
		model.addAttribute("Examinations", examList);
		
		// return an HTML file, schedule.html, to the browser
		return "schedule";
	}
	*/
	
}
