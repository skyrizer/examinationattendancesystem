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
	 //ni dapat sudah
	 
	   @Query(value="SELECT s.StudentName, s.StudentMatricNo " 
	          + "FROM Student s " 
	          + "LEFT JOIN ExaminationAttendance e ON s.StudentId = e.StudentId AND e.ExaminationId = :ExaminationId " 
	          + "WHERE e.ExamAttendStatus IS NULL OR e.ExamAttendStatus = ''",nativeQuery=true)
	    public List<Object[]> getStudentsWithNullAttendStatusAndExaminationId(@Param("ExaminationId") int ExaminationId);
	 
	 /*
	 @Query(value="SELECT s.StudentName, s.StudentMatricNo "
	 		+ "FROM Student s "
	 		+ "LEFT JOIN ExaminationAttendance e ON s.StudentId = e.StudentId AND e.ExaminationId = :ExaminationId "
	 		+ "LEFT JOIN Examination ex ON e.ExaminationId = ex.ExaminationId "
	 		+ "LEFT JOIN subjectt su ON ex.SubjectId = su.SubjectId AND su.SubjectId = 2 "
	 		+ "WHERE e.ExamAttendStatus IS NULL OR e.ExamAttendStatus = ''",nativeQuery=true)
	  public List<Object[]> getStudentsWithNullAttendStatusAndExaminationId(@Param("ExaminationId") int ExaminationId);
	  */
}
