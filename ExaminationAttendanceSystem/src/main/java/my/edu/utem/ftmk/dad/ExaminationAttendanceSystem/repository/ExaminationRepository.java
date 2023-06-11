/*package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

	@Query(value = "select e.ExaminationDate,  e.ExaminationTime, s.SubjectCode, s.SubjectName, u.UnitName, "
			+ "e.examinationId"
			+ " FROM Examination e, Subject s, ExaminationUnit u "
			+ "WHERE e.SubjectId = s.SubjectId AND e.UnitId = u.UnitId",
			nativeQuery = true)
	public List<Object[]> selectCustomByCode(); 
	
	

}


*/