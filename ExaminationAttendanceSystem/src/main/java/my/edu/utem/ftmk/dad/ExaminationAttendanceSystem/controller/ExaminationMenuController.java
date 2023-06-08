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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;

@Controller
public class ExaminationMenuController {

	private String defaultURI; 
	
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
