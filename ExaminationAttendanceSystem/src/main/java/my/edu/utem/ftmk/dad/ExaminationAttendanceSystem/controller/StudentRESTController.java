package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.ExaminationRepository;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentRESTController {
	
	@Autowired
	private StudentRepository students;
	
	@GetMapping("/matric/{studentMatricNo}")
	public Student findStudentIdByMatricNo(@PathVariable String studentMatricNo)
	{ 
		
		return students.findStudentIdByMatricNo(studentMatricNo);
	}
	
	@GetMapping("{studentId}")
	public Student getByStudentId(@PathVariable Long studentId)
	{ 
		
		return students.findById(studentId).get();
	}
}
