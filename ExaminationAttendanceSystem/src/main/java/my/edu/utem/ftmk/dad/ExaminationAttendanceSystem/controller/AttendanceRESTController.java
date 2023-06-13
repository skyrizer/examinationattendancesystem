package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.AttendanceRepository;


import org.springframework.ui.Model;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.StudentRepository;

@RestController
@RequestMapping("/api/attend")
public class AttendanceRESTController {

	@Autowired
	private AttendanceRepository attendanceRepository;
	
	/*
	 * @DeleteMapping("{orderTypeId}") public ResponseEntity<HttpStatus>
	 * deleteOrderType(@PathVariable long orderTypeId) {
	 * attendanceRepository.deleteById(orderTypeId);
	 * 
	 * return new ResponseEntity<>(HttpStatus.OK); }
	 */
	
	
	//For class ExaminationAttendace
	
	//retrieve all examination detail
	@GetMapping
	public List<ExaminationAttendance> getExaminationAttendance()
	{
		return attendanceRepository.findAll();
		
	}
	
	//retrieve examination attendance based on examination ID
	@GetMapping("{examinationAttendanceId}")
	public ExaminationAttendance getExamAttendId(@PathVariable long ExamAttendId)
	{
		ExaminationAttendance examinationAttendance = attendanceRepository.findById(ExamAttendId).get();
		
		return examinationAttendance;
	}
	
	@GetMapping("/Venue/{UnitId}")
	public List<ExaminationAttendance> getAttendanceByUnit (@PathVariable long UnitId)
	{
		return attendanceRepository.getAttendanceByVenue(UnitId);
	}
	
	//insert records for examination attendance
	@PostMapping
	public ExaminationAttendance insertExaminationAttendance(@RequestBody ExaminationAttendance examinationAttendance)
	{
		return attendanceRepository.save(examinationAttendance);
	}
	

	//update records for examination attendance
	@PutMapping
	public ExaminationAttendance updateExaminationAttendance(@RequestBody ExaminationAttendance examinationAttendance)
	{
		return attendanceRepository.save(examinationAttendance);
	}
	
	//retrieve examination attendance based on examination ID
	@GetMapping("/report/{examinationId}")
	public List<ExaminationAttendance> findExaminationId(@PathVariable Long examinationId)
	{ 
		
		return attendanceRepository.findExaminationId(examinationId);
	}
	
	
}
