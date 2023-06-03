package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.AttendanceRepository;


@RestController
@RequestMapping("/api/attend")
public class AttendanceRESTController {

	@Autowired
	private AttendanceRepository attendance;
	
	/*
	 * This method will insert the attendance record to the database
	*/ 
	@PostMapping("/")
	public ExaminationAttendance recordAttendance(@RequestBody ExaminationAttendance examinationattendance)
	{
		return attendance.save(examinationattendance);
	}
	

	@GetMapping("/")
	public List<ExaminationAttendance> generateAttendanceReport(@RequestBody Student student, Examination exam)
	{ 
		return attendance.findAll();
	}
	
}
