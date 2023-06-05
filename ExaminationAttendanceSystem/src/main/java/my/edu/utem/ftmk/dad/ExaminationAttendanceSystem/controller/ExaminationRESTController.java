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
}
