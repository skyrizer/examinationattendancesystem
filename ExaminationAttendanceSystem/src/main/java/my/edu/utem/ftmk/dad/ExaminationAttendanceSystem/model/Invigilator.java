package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ingivilator")
public class Invigilator extends Lecturer{

	//private int ExaminationId;
	
	public Invigilator(String LecturerId)
	{
		super();
	}
}
