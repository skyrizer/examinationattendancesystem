package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	//public Student findByStudentMatricNo(String StudentMatricNo);
	@Query(value="SELECT * FROM Student "
			+ " WHERE StudentMatricNo = :StudentMatricNo", nativeQuery = true)
	
    public Student findStudentIdByMatricNo(@Param("StudentMatricNo") String StudentMatricNo);
	//public abstract List<Student> findByStudentByMatric(String StudentMatricNo);
	 
}

