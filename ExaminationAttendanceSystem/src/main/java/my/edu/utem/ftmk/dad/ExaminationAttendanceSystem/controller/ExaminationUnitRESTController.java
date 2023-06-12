package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model.ExaminationUnit;
import my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.repository.ExaminationUnitRepository;

/*
 * This class mainly used to retrieve all examination unit in dropdown menu list.
 * 
 * @author Ng Wei Hen
 */
@RestController
@RequestMapping("/api/venue")
public class ExaminationUnitRESTController {

	@Autowired
	private ExaminationUnitRepository examUnit;
	
	/* retrieve all examination units' information
	 * @author Ng Wei Hen
	 * 
	 * @return a list of all examination units' information
	 */
	@GetMapping
	public List<ExaminationUnit> getExamination()
	{
		return examUnit.findAll();
	}
}
