package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Lecturer;

/*
 * This repository enable LecturerRESTController to invoke it for web service.
 * 
 * @author Ng Wei Hen
 */

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

}
