package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Subject;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.SubjectRepository;

@RestController
@RequestMapping("/api/subjects")
public class SubjectRESTController {

	@Autowired
	private SubjectRepository subjects;
	
	@GetMapping
	public List<Subject> getSubject()
	{
		return subjects.findAll();
	}
}
