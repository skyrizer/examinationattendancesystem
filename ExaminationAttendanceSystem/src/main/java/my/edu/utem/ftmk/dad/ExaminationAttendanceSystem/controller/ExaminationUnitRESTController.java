package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationUnit;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.ExaminationUnitRepository;

@RestController
@RequestMapping("/api/venue")
public class ExaminationUnitRESTController {

	@Autowired
	private ExaminationUnitRepository examUnit;
	
	@GetMapping
	public List<ExaminationUnit> getExamination()
	{
		return examUnit.findAll();
	}
}
