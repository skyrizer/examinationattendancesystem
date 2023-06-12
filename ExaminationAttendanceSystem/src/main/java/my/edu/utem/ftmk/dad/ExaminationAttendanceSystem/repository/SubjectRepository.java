package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.Subject;

/*
 * This repository enable SubjectRESTController to invoke it for web service.
 * 
 * @author Ng Wei Hen
 */

public interface SubjectRepository extends JpaRepository<Subject, Long> {

	
}
