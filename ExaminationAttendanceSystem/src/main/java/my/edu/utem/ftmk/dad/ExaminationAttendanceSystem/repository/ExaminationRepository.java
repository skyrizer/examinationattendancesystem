package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

	/*
	 * This method create custom query for retrieve schedule for students
	 * 
	 */
	@Query(value = "select t.SubjectCode, t.SubjectName, e.ExaminationDate, e.ExaminationTime, u.UnitName "
			+ "from subject t, examination e, examinationunit u WHERE t.SubjectId = e.SubjectId AND e.UnitId = u.UnitId ",
			nativeQuery = true)
	public List<Object[]> selectCustomByCode();
}
