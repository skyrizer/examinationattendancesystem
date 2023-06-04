package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;

@Repository
public interface AttendanceRepository extends JpaRepository<ExaminationAttendance, Long> {


}