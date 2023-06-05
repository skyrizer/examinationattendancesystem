package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

}
