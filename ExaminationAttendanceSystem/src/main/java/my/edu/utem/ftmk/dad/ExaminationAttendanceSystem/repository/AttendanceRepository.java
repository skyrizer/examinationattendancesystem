package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;

@Repository
public interface AttendanceRepository extends JpaRepository<ExaminationAttendance, Long> {
	
	/*
	 * Create custom query for filter attendance table based on Venue, which is UnitId
	 * Author : Ng wei hen
	 */
	@Query(value = "SELECT a.* FROM ExaminationAttendance a "
			+ " JOIN Examination e ON a.ExaminationId = e.ExaminationId"
			+ " JOIN ExaminationUnit u ON u.UnitId = e.UnitId WHERE "
			+ " u.UnitId = :UnitId", nativeQuery = true)
	public List<ExaminationAttendance> getAttendanceByVenue(@Param("UnitId") long UnitId);
	//public List<ExaminationAttendance> findById(int ExamAttendId);
	//public List<ExaminationAttendance> findByStudentId_StudentMatricNo(String studentMatricNo);
	
	
	/*
	 * Create custom query for selecting ExaminationId based on StudentMatricNo entered by user
	 * Author : Hafiz Suhaizal
	 */
	 @Query(value = "SELECT * from examinationAttendance WHERE ExaminationId = :ExaminationId", nativeQuery = true)
	 
	 public List<ExaminationAttendance> findExaminationId(@Param("ExaminationId") Long ExaminationId);
	 
	 /*
	  * Still in testing phase
	  * Create custom query for filter attendance table that shows the list of absent student
	  * Author : Hafiz Suhaizal
	  */
	 @Query(value="SELECT e.ExamAttendId,e.ExamAttendStatus,e.InputType,e.ExaminationId,e.StudentId,s.StudentName, s.StudentMatricNo "
	 		+ "FROM student s LEFT JOIN examinationattendance e ON s.StudentId = e.StudentId AND e.ExaminationId= :ExaminationId"
	 		+ " WHERE e.ExamAttendId is NULL",nativeQuery=true)
	 
	 public List<ExaminationAttendance> getAttendanceByStatus(@Param("ExaminationId")long ExaminationId);
	 
	 
	
	 
	
}
