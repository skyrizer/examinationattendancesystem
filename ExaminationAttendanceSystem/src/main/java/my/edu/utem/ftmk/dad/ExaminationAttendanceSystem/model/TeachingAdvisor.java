package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="teachingadvisor")
public class TeachingAdvisor extends Lecturer {

	private String Student_id;
	
	public TeachingAdvisor(String lecturer_id)
	{
		super();
	}
}
