package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ingivilator")
public class Invigilator {

	private int Examination_id;
	
	public Invigilator(String lecturer_id)
	{
		super();
	}
}
