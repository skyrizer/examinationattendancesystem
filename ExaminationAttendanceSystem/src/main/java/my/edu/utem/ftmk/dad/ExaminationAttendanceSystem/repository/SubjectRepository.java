package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
