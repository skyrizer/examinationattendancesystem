/*package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Invigilator;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Lecturer;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.LecturerRepository;

@RestController
@RequestMapping("")
public class LecturerRESTController implements AttendanceInput{

	@Autowired
	private LecturerRepository lecturerRepos;
	
	@GetMapping
	public List<String> generateTeachingAdvisor(Student student)
	{
		return lecturerRepos.findAll();
	}
	
	@GetMapping
	public List<String> generateInvigilator(Examination exam)
	{
		return lecturerRepos.findAll();
	}
	
	public boolean selfCheckInApproval(Lecturer lecturer, Student student, Invigilator invigilators)
	{
		boolean answer = false;
		
		if(lecturer.getLecturer_id().equals(invigilators))
		{
			answer = true;
		}
		return answer;
	}

	@Override
	public void generateAttendanceInput() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}*/
