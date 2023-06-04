package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.AttendanceRepository;

import org.springframework.ui.Model;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.ExaminationRepository;

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
	public List<ExaminationAttendance> generateAttendanceReport()
	{ 
		return attendance.findAll();
	}


	
	@GetMapping("/{id}")
	public List<ExaminationAttendance> searchRecordAttendId(@PathVariable int id)
	{
		return attendance.findById(id);
	}

	
	/*//ignore this for a while
	@GetMapping("/students/new")
	public String createStudentAttendance(Model model)
	{
		//create student object to hold student form data
		Student student=new Student();
		model.addAttribute("student",student);
		return "create_student";
	}*/
	
}
