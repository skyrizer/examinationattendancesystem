package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationAttendance;

/*
 * This repository enable AttendanceRESTController to invoke it for web service.
 * 
 * @author Ng Wei Hen
 * @author Hafiz Suhaizal Bin Ismail
 */
@Repository
public interface ExaminationAttendanceRepository extends JpaRepository<ExaminationAttendance, Long> {
	
}

