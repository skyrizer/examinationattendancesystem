package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
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
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationUnit;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Subject;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.AttendanceRepository;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Lecturer;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;

@Controller
public class ExaminationMenuController {

	@Autowired
	private AttendanceRepository attendanceRepository;
	
	private String defaultURI = "http://localhost:8080/examinationattendancesystem/api/examination/schedule"; 
	
	/*
	 * This method enables to display a list of examination schedule 
	 * which is retrieved based on cross joining table
	 * 
	 * @author Ng Wei Hen
	 * @param filterBy
	 * @param id
	 * 
	 * @return
	 */
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
				}
				else if(filterBy.equals("subj")) {
					
				}
			}catch (Exception e) { 
				
			}
		}
		// The URI for GET examination schedule
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Examination[]> response = restTemplate.getForEntity(uri, Examination[].class);
		
		// Parse JSON data to array of object
		Examination examination[] = response.getBody();
		
		// Parse an array to a list object
		List<Examination> examList = Arrays.asList(examination);
		
		// Attach list to model as attribute
		model.addAttribute("Examinations", examList);
		
		// return an HTML file, schedule.html, to the browser
		return "schedule";
	}
	
	/*
	 * This method will update or insert an examination schedule
	 * 
	 * @author Ng Wei Hen
	 * @param examType
	 * 
	 * @return
	 */
	@RequestMapping("/schedule/save")
	public String updateInsertExamination(@ModelAttribute Examination examType)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<Examination> request =new HttpEntity<Examination>(examType);
		
		String examTypeResponse = " ";
		
		if (examType.getExaminationId() > 0)
		{
			// This block update an new examination schedule and
			
			// Send request as PUT
			restTemplate.put("http://localhost:8080/examinationattendancesystem/api/examination", request, Examination.class);
		}
		else
		{
			// This block add a new examination schedule
			
			// send request as POST
			examTypeResponse = restTemplate.postForObject("http://localhost:8080/examinationattendancesystem/api/examination", request, String.class);
		}
		
		System.out.println(examTypeResponse);
		
		// Redirect request to display a list of examination schedule
		return "redirect:/schedule";
	}
	
	/**
	 * This method gets an examination schedule
	 * 
	 * @author Ng Wei Hen
	 * 
	 * @param ExaminationId
	 * @param model
	 * @return
	 */
	@GetMapping("/schedule/{ExaminationId}")
	public String getExamType (@PathVariable Integer ExaminationId, Model model) {
		
		String pageTitle = "New Examination Schedule";
		Examination examType = new Examination();
		
		// This block get an examination schedule to be updated
		if (ExaminationId > 0) {

			// Generate new URI and append ExaminationId to it
			String uri = "http://localhost:8080/examinationattendancesystem/api/examination/" + ExaminationId;
			System.out.println(uri);
			
			// Get an examination schedule from the web service
			RestTemplate restTemplate = new RestTemplate();
			examType = restTemplate.getForObject(uri, Examination.class);
			
			//Give a new title to the page
			pageTitle = "Edit Examination Schedule";
		}
		
		/*
		 *  The URI for GET Examination Subject.
		 *	List of All subjects for drop down list menu
		 * 		
		 */

		RestTemplate restTemplateSubj = new RestTemplate();
		ResponseEntity<Subject[]> responseSubj = restTemplateSubj.getForEntity("http://localhost:8080/examinationattendancesystem/api/subjects",
				Subject[].class);

		Subject subjArray[] = responseSubj.getBody();
		
		// Parse an array to a list object
		List<Subject> subjList = Arrays.asList(subjArray);
		
		/*
		 *  The URI for GET Examination Unit.
		 *	List of All examination units for drop down list menu
		 * 		
		 */
		RestTemplate restTemplateUnit = new RestTemplate();
		ResponseEntity<ExaminationUnit[]> responseUnit = restTemplateUnit.getForEntity("http://localhost:8080/examinationattendancesystem/api/venue",
				ExaminationUnit[].class);

		ExaminationUnit unitArray[] = responseUnit.getBody();

		// Parse an array to a list object
		List<ExaminationUnit> unitList = Arrays.asList(unitArray);
		
		
		/*
		 *  The URI for GET lecturers.
		 *	List of All lecturers for drop down list menu
		 * 		
		 */
		RestTemplate restTemplateLect = new RestTemplate();
		ResponseEntity<Lecturer[]> responseLect = restTemplateLect.getForEntity("http://localhost:8080/examinationattendancesystem/api/lectures",
				Lecturer[].class);

		Lecturer lectArray[] = responseLect.getBody();

		// Parse an array to a list lecturer list
		List<Lecturer> LectList = Arrays.asList(lectArray);
		
		
		// Attach value to pass to front end
		model.addAttribute("examType", examType);
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("Subjects", subjList);
		model.addAttribute("Lecturers", LectList);
		model.addAttribute("examUnit",unitList );
		
		// return an HTML file, scheduleinfo.html, to the browser
		return "scheduleinfo";
			
	}

	/**
	 * This method deletes an schedule
	 * 
	 * @author Ng Wei Hen
	 * 
	 * @param examId
	 * @return
	 */
	@RequestMapping("/schedule/delete/{examId}")
	public String deleteExamType(@PathVariable Integer examId)
	{
		// Generate new URI, similar to the mapping in ExaminationRESTController
		String uri = "http://localhost:8080/examinationattendancesystem/api/examination/" + "{examId}";
		
		// Send a DELETE request and attach the value of examId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("examId", Integer.toString(examId)));
		
		return "redirect:/schedule";
	}
	
	
	/**
	 * This method will GET list of subject.
	 * Author :Wafir Dzihni
	 * @param Examination
	 * @return
	 */
	
	@GetMapping("/report")
	public String getExamTypes(Model model)
	{
		// The URI for GET order types
		String uri = "http://localhost:8080/examinationattendancesystem/api/examination";
		
		//Get a list of examination from the web service
		RestTemplate restReport = new RestTemplate();
		ResponseEntity<Examination[]> response = restReport.getForEntity(uri, Examination[].class);
		
		// Parse JSON data to array of object
		Examination examination[] = response.getBody();
		
		// Parse an array to a list object
		List<Examination> examList = Arrays.asList(examination);
		
		// Attach list to model as attribute
		model.addAttribute("ExaminationsReport", examList);
		
		// return an HTML file, AttendanceReport.html, to the browser
		return "/AttendanceReport";
	}
	
	/*
	 * This method retrieves the list of examinations and prepares the model for the AttendanceExaminationSchedule view.
	 * 
	 * @param model The model object used to pass data to the view
	 * @return The name of the view file, AttendanceExaminationSchedule.html, to be rendered by the browser
	 * @author : Hafiz Suhaizal
	 */
	@GetMapping("/ExaminationList")
	public String getExamList(Model model)
	{
		// The URI for GET examination list
		String uri = "http://localhost:8080/examinationattendancesystem/api/examination";
		String pageTitle = "Report For Absent Student";
		
		// Get the list of examinations from the web service
		RestTemplate restReport = new RestTemplate();
		ResponseEntity<Examination[]> response = restReport.getForEntity(uri, Examination[].class);
		
		// Parse JSON data to array of object
		Examination examination[] = response.getBody();
		
		// Parse an array to a list object
		List<Examination> examList = Arrays.asList(examination);
		
		// Attach list to model as attribute
		model.addAttribute("ExaminationsReport", examList);
		model.addAttribute("pageTitle", pageTitle);
		// return an HTML file, AttendanceExaminationSchedule.html, to the browser
		return "/AttendanceExaminationSchedule";
	}
	
}
