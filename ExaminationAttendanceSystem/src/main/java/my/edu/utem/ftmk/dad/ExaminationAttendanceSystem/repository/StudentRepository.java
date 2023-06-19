package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	/*
	 * Finds a student by their matriculation number.
	 *
	 * This method executes a custom SQL query to retrieve a student entity based on their matriculation number.
	 *
	 * @param studentMatricNo The matriculation number of the student to find.
	 * @return The Student entity matching the given matriculation number, or null if not found.
	 *
	 * The query selects all columns from the "Student" table where the "StudentMatricNo" column matches
	 * the specified matriculation number.
	 * @author: Hafiz Suhaizal
	 */
	@Query(value="SELECT * FROM Student "
			+ " WHERE StudentMatricNo = :StudentMatricNo", nativeQuery = true)
	
    public Student findStudentIdByMatricNo(@Param("StudentMatricNo") String StudentMatricNo);
	//public abstract List<Student> findByStudentByMatric(String StudentMatricNo);
	 
}

