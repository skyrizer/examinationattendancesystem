package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

}
