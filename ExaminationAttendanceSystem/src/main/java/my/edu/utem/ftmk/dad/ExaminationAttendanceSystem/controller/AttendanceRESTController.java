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
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.AttendanceRepository;

@RestController
@RequestMapping("/api/attend")
public class AttendanceRESTController {

	@Autowired
	private AttendanceRepository attendanceRepository;
	
	/*
	 * This method retrieves the list of all ExaminationAttendance entities.
	 * 
	 * @return The list of all ExaminationAttendance entities in the database
	 * @author :Hafiz Suhaizal
	 */
	@GetMapping
	public List<ExaminationAttendance> getExaminationAttendance()
	{
		// Retrieve and return the list of all ExaminationAttendance entities
		return attendanceRepository.findAll();
		
	}
	
	/*
	 * This method retrieves the ExaminationAttendance entity with the specified examinationAttendanceId.
	 * 
	 * @param examinationAttendanceId The ID of the ExaminationAttendance entity to retrieve
	 * @return The ExaminationAttendance entity with the given examinationAttendanceId
	 * @throws NoSuchElementException if the ExaminationAttendance entity does not exist with the provided ID
	 * @author : Hafiz Suhaizal
	 */
	@GetMapping("{examinationAttendanceId}")
	public ExaminationAttendance getExamAttendId(@PathVariable long ExamAttendId)
	{
		 // Retrieve the ExaminationAttendance entity with the given examinationAttendanceId
		ExaminationAttendance examinationAttendance = attendanceRepository.findById(ExamAttendId).get();
		
		return examinationAttendance;
	}
	
	/*
	 * This method retrieves the list of ExaminationAttendance entities associated with a specific unit (venue).
	 * 
	 * @param unitId The ID of the unit (venue) to retrieve attendance data for
	 * @return The list of ExaminationAttendance entities for the given unitId
	 * @author : Ng Wei Hen
	 */
	@GetMapping("/Venue/{UnitId}")
	public List<ExaminationAttendance> getAttendanceByUnit (@PathVariable long UnitId)
	{
		 // Retrieve the list of ExaminationAttendance entities for the given unitId
		return attendanceRepository.getAttendanceByVenue(UnitId);
	}
	
	/*
	 * This method inserts a new ExaminationAttendance entity into the database.
	 * 
	 * @param examinationAttendance The ExaminationAttendance entity to be inserted
	 * @return The inserted ExaminationAttendance entity with assigned ID and any additional modifications made by the database
	 * @author : Hafiz Suhaizal
	 */
	@PostMapping
	public ExaminationAttendance insertExaminationAttendance(@RequestBody ExaminationAttendance examinationAttendance)
	{
		// Insert the provided ExaminationAttendance entity into the database
		return attendanceRepository.save(examinationAttendance);
	}
	
	/*
	 * This method retrieves the list of ExaminationAttendance entities for a specific examination.
	 * 
	 * @param examinationId The ID of the examination to retrieve attendance data for
	 * @author : Hafiz Suhaizal
	 */
	@GetMapping("/report/{examinationId}")
	public List<ExaminationAttendance> findExaminationId(@PathVariable Long examinationId)
	{ 
		// Retrieve the list of ExaminationAttendance entities for the given examinationId
		return attendanceRepository.findExaminationId(examinationId);
	}
	
	/*
	 * This method retrieves the list of students who have a null attendance status for a specific examination.
	 * 
	 * @param examinationId The ID of the examination to retrieve students with null attendance status for
	 * @return The list of Student entities with null attendance status for the given examinationId
	 * @author : Hafiz Suhaizal
	 */
	@GetMapping("/students/absent/{ExaminationId}")
	public List<Student> getStudentsWithNullAttendStatusAndExaminationId(@PathVariable int ExaminationId) {
		// Retrieve the list of students with null attendance status for the given examinationId
		List<Object[]> queryResult = attendanceRepository.getStudentsWithNullAttendStatusAndExaminationId(ExaminationId);
	    List<Student> studentList = new ArrayList<>();

	    for (Object[] row : queryResult) {
	        String studentName = (String) row[1];
	        String studentMatricNo = (String) row[2];
	        String studentCourse = (String) row[3];

	        Student student = new Student();
	        student.setStudentName(studentName);
	        student.setStudentMatricNo(studentMatricNo);
	        student.setStudentCourse(studentCourse);

	        studentList.add(student);
	    }
	    
	    
	    return studentList;
	}
	
	/*
	 * This method retrieves the list of ExaminationAttendance entities for a specific examination.
	 * 
	 * @param examinationId The ID of the examination to retrieve attendance data for
	 * @return The list of ExaminationAttendance entities for the given examinationId
	 * @author : Hafiz Suhaizal
	 */
	@GetMapping("/examination/{examinationId}")
	public List<ExaminationAttendance> findExaminationI(@PathVariable Long examinationId)
	{ 
		// Retrieve and return the list of ExaminationAttendance for the given examinationId
		return attendanceRepository.findExaminationI(examinationId);
	}

	
}
