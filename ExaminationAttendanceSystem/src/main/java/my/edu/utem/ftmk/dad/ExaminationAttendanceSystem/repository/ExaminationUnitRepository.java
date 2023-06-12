package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationUnit;


/*
 * This repository enable ExaminationUnitRESTController to invoke it for web service.
 * 
 * @author Ng Wei Hen
 */
public interface ExaminationUnitRepository extends JpaRepository<ExaminationUnit, Long> {

}
