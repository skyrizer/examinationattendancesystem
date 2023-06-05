package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.ExaminationRepository;

@RestController
@RequestMapping("/api/examination")
public class ExaminationRESTController {

	@Autowired
	private ExaminationRepository exams;
	
	/*
	 * This method demonstrate the invocation of custom query and return the
	 * result in Object form.
	 * 
	 * @return A list of objects where value of each field in separated arrays
	 */
	@GetMapping("/find/schedule/raw")
	public List<Object[]> getSchedule(){
		
		// Execute query method
		List<Object[]> objOrderTypes = exams.selectCustomByCode();
		
		// For debugging purpose
		for(Object[] objOrderType: objOrderTypes) {
			
			for(Object currentObject: objOrderType) {
				
				System.out.println(currentObject.toString());
			}
		}
		
		return objOrderTypes;
	}
}
