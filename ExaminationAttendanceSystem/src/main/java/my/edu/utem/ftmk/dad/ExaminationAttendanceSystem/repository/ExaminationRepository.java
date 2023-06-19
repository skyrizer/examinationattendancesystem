package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

	/*
	 * Retrieves a custom list of examination details.
	 *
	 * This method executes a custom SQL query to retrieve examination details including the examination date,
	 * time, subject code, subject name, unit name, and examination ID.
	 *
	 * @return A list of Object arrays containing the examination details.
	 *
	 * Each Object array in the list represents a single row of the result set. The elements in the array
	 * correspond to the selected columns in the query: ExaminationDate, ExaminationTime, SubjectCode, SubjectName,
	 * UnitName, and ExaminationId.
	 * @author : Ng Wei Hen
	 */
	@Query(value = "select e.ExaminationDate,  e.ExaminationTime, s.SubjectCode, s.SubjectName, u.UnitName, "
			+ "e.examinationId"
			+ " FROM Examination e, Subject s, ExaminationUnit u "
			+ "WHERE e.SubjectId = s.SubjectId AND e.UnitId = u.UnitId",
			nativeQuery = true)
	public List<Object[]> selectCustomByCode(); 
	
}


