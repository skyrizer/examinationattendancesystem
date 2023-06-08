package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	//public Student findByStudentMatricNo(String StudentMatricNo);

	//public abstract List<Student> findByStudentByMatric(String StudentMatricNo);
}
