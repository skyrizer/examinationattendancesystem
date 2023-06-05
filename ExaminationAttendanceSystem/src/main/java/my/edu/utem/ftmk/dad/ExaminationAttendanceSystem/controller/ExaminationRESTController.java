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
	
	// retrieve all order types detail
	@GetMapping
	public List<Examination> getExamination()
	{
		return exams.findAll();
	}
	
	@GetMapping("/find/schedule/wrap")
	public List<Object> getWrapPickUpOrderCode() {
		
		// Execute query method
		List<Object[]> objExam = exams.selectCustomByCode();
		
		// Wrap result in a list of order type
		List<Object> examTypes = new ArrayList<Object>();
		for (Object[] exam:objExam) {
			
			// Wrap in order type
			Subject subject = new Subject();
			Examination exams = new Examination();
			ExaminationUnit units = new ExaminationUnit();
			
			subject.setSubjectCode(exam[0].toString());
			subject.setSubjectName(exam[1].toString());
			
            String strDate = exam[2].toString();
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
			exams.setExaminationTime(exam[3].toString());
			units.setUnitName(exam[4].toString());
			
			// Add into list
			examTypes.add(subject);
			examTypes.add(exams);
			examTypes.add(units);
		}
		
		return examTypes;
	}

}
