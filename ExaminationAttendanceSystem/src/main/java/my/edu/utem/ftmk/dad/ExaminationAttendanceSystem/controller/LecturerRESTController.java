package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Lecturer;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.LecturerRepository;

/*
 * This class mainly used to display all lecturers in dropdown menu list.
 * 
 * @author Ng Wei Hen
 */

@RestController
@RequestMapping("/api/lectures")
public class LecturerRESTController{

	@Autowired
	private LecturerRepository lecturerRepos;
	
	
	/* retrieve all lecturers' information
	 * @author Ng Wei Hen
	 * 
	 * @return a list of all lecturers' information
	 */
	@GetMapping
	public List<Lecturer> getExamination()
	{
		return lecturerRepos.findAll();
	}
	
}
