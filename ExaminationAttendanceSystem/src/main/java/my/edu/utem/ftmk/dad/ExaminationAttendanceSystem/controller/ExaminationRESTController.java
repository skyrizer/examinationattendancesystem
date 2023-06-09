package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Date; 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

import ch.qos.logback.core.model.Model;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Subject;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationUnit;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Lecturer;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.ExaminationRepository;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.LecturerRepository;

@RestController
@RequestMapping("/api/examination")
public class ExaminationRESTController {

	@Autowired
	private ExaminationRepository exams;
	
	@Autowired
	private LecturerRepository lecturerRepository;
	
	// retrieve all order types detail
	@GetMapping
	public List<Examination> getExamination()
	{
		return exams.findAll();
	}
	
	@GetMapping("{examId}")
	public Examination getSpecific(@PathVariable Long examId) {
		return exams.findById(examId).get();
	}
	
	@PostMapping
	@PutMapping
	public Examination insertUpdate(@RequestBody Examination examination) {
		return exams.save(examination);
	}
	 
	
	

	//test
	@GetMapping("/test/{lid}")
	public Lecturer testfunc(@PathVariable long lid){
		return lecturerRepository.findById(lid).get();
	}
	
	/*
	
	@GetMapping("/list")
	public List<Examination> getWrapPickUpOrderCode() {
		
		// Execute query method
		List<Object[]> objExams = exams.selectCustomByCode();
		
		// Wrap result in a list of order type
		List<Examination> examinations = new ArrayList<Examination>();
		for (Object[] objExam:objExams) {
			
			// 5 elements in one objExam
			
			Examination examination = new Examination();
			
			// Wrap date
			String strDate = objExam[0].toString(); 
			Date date = new Date();
			
			// Wrap time
			
			// Wrap subject
			Subject subject = new Subject();
			subject.setSubjectCode(objExam[2].toString());
			subject.setSubjectName(objExam[3].toString());
			examination.setSubject(subject);
			System.out.println(this.getClass().getSimpleName() + " @ 66 " + examination.getSubject().getSubjectName());
			
			// Wrap unit id
			//int unitId = Integer.parseInt( objExam[4].toString()); 
		//	examination.setUnitName(objExam[4].toString());
		//	System.out.println(this.getClass().getSimpleName() + " @ 66 " + examination.getUnitName());
			
			
			examination.setExaminationId(Integer.parseInt(objExam[5].toString()));
			
			examinations.add(examination);
			
			
			  // Wrap in order type 
			/*Subject subject = new Subject(); 
				Examination exams = new Examination(); ExaminationUnit units = new ExaminationUnit();
			  
			  String strDate = exam[0].toString(); System.out.println(strDate);
			  
			   SimpleDateFormat formatter = new
			  SimpleDateFormat("yyyy-MM-dd"); try { date = formatter.parse(strDate);
			  System.out.println(formatter.format(date)); } catch (ParseException e) {
			  e.printStackTrace(); }
			  
			  exams.setExaminationDate(date); exams.setExaminationTime(exam[1].toString());
			  subject.setSubjectCode(exam[2].toString());
			  subject.setSubjectName(exam[3].toString());
			 
			  
			  // Add into list examTypes.add(subject); examTypes.add(exams);
			  examTypes.add(units);
			 
		}
		
		return examinations;
	}*/
	

}
