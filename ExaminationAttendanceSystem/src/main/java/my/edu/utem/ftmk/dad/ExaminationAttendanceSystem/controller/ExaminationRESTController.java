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
	
	/*
	 * This method retrieve all examination schedule information
	 * based on venue.
	 * 
	 * @author Ng Wei Hen
	 * @return A list of examination schedule
	 */
	@GetMapping
	public List<Examination> getExamination()
	{
		return exams.findAll();
	}
	
	/*
	 * This method retrieve all examination schedule by Examination Id
	 * 
	 * @author Ng Wei Hen
	 * @param examId
	 * @return A list of examination schedule based on ExamId
	 * 
	 */
	@GetMapping("{examId}")
	public Examination getSpecific(@PathVariable Long examId) {
		return exams.findById(examId).get();
	}
	
	/*
	 * This method inserts a new Examination schedule
	 * 
	 * @author Ng Wei Hen
	 * @param examination
	 * 
	 */
	@PostMapping
	public Examination insertSchedule(@RequestBody Examination examination) {
		return exams.save(examination);
	}
	
	/*
	 * This method updates a current Examination schedule
	 * 
	 * @author Ng Wei Hen
	 * @param examination
	 * 
	 */
	@PutMapping
	public Examination UpdateSchedule(@RequestBody Examination examination) {
		return exams.save(examination);
	}
	 
	/*
	 * This method deletes a current Examination schedule
	 * based on ExaminationId
	 * 
	 * @author Ng Wei Hen
	 * @param examId
	 * 
	 */
	@DeleteMapping("{examId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long examId)
	{
		exams.deleteById(examId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

