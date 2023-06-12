package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	public Examination insertSchedule(@RequestBody Examination examination) {
		return exams.save(examination);
	}
	
	@PutMapping
	public Examination UpdateSchedule(@RequestBody Examination examination) {
		return exams.save(examination);
	}
	 
	// delete order type record based on Id
	@DeleteMapping("{examId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long examId)
	{
		exams.deleteById(examId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	//test
	@GetMapping("/test/{lid}")
	public Lecturer testfunc(@PathVariable long lid){
		return lecturerRepository.findById(lid).get();
	}
	
	
}

