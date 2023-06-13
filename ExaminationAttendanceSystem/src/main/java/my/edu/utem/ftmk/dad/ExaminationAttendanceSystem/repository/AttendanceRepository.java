package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;

@Repository
public interface AttendanceRepository extends JpaRepository<ExaminationAttendance, Long> {
	
	/*
	 * Create custom query for filter attendance table based on Venue, which is UnitId
	 */
	@Query(value = "SELECT a.* FROM ExaminationAttendance a "
			+ " JOIN Examination e ON a.ExaminationId = e.ExaminationId"
			+ " JOIN ExaminationUnit u ON u.UnitId = e.UnitId WHERE "
			+ " u.UnitId = :UnitId", nativeQuery = true)
	public List<ExaminationAttendance> getAttendanceByVenue(@Param("UnitId") long UnitId);
	//public List<ExaminationAttendance> findById(int ExamAttendId);
	//public List<ExaminationAttendance> findByStudentId_StudentMatricNo(String studentMatricNo);
	
	
	
}

/* @Modifying
	    @Query(value = "INSERT INTO examinationattendance (attendance_status, input_type, examination_id, student_id) " +
	            "SELECT 'hadir', e.inputType, 1, s.studentId " +
	            "FROM student s " +
	            "CROSS JOIN examination e " +
	            "WHERE s.studentMatricNo = :matricNo", nativeQuery = true)
	    ExaminationAttendance insertAttendance(@Param("matricNo") String matricNo);*/