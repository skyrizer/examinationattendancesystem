package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Date; 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Subject;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationUnit;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;
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
		List<Object[]> objExams = exams.selectCustomByCode();
		
		// For debugging purpose
		for(Object[] objexam: objExams) {
			
			for(Object currentObject: objexam) {
				
				System.out.println(currentObject.toString());
			}
		}
		
		return objExams;
	}
	
	@GetMapping("/schedule")
	public List<Object> getWrapPickUpOrderCode() {
		
		// Execute query method
		List<Object[]> objOrderTypes = exams.selectCustomByCode();
		
		// Wrap result in a list of order type
		List<Object> orderTypes = new ArrayList<Object>();
		for (Object[] objOrderType:objOrderTypes) {
			
			// Wrap in order type
			Subject subject = new Subject();
			Examination exams = new Examination();
			ExaminationUnit units = new ExaminationUnit();
			
		
			subject.setSubjectCode(objOrderType[0].toString());
			subject.setSubjectName(objOrderType[1].toString());
			
            String strDate = objOrderType[2].toString();
            System.out.println(strDate);
			
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
            	date = formatter.parse(strDate);
            	System.out.println(formatter.format(date));
            }
            catch (ParseException e) {
            	e.printStackTrace();
            }
            
            exams.setExaminationDate(date);
			exams.setExaminationTime(objOrderType[3].toString());
			units.setUnitName(objOrderType[4].toString());
			
			// Add into list
			orderTypes.add(subject);
			orderTypes.add(exams);
			orderTypes.add(units);
		}
		
		return orderTypes;
	}
	
}
