package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;

/*
 * This repository enable AttendanceRESTController to invoke it for web service.
 * 
 * @author Ng Wei Hen
 * @author Hafiz Suhaizal Bin Ismail
 */
@Repository
public interface ExaminationAttendanceRepository extends JpaRepository<ExaminationAttendance, Long> {
	
	@Query(value = "SELECT * FROM Examination e, ExaminationAttendance a, ExaminationUnit u "
			+ "WHERE a.ExaminationId = e.ExaminationId AND"
			+ "e.UnitId = u.UnitId AND"
			+ "u.UnitId = :UnitId", nativeQuery = true)
	public List<ExaminationAttendance> getAttendanceByVenue(@Param("UnitId") String UnitId);
	
	
}

