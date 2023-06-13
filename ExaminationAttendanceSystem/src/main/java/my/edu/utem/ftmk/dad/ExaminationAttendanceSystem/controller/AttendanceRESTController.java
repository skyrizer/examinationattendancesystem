package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.AttendanceRepository;

@RestController
@RequestMapping("/api/attend")
public class AttendanceRESTController {

	@Autowired
	private AttendanceRepository attendanceRepository;
	
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
