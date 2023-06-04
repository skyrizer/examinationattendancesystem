package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// test 

@Entity
@Table(name="faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FacultyId")
	private int FacultyId;
	
	@Column(name = "FacultyName")
	private String FacultyName;

	public int getFacultyId() {
		return FacultyId;
	}

	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}

	public String getFacultyName() {
		return FacultyName;
	}

	public void setFacultyName(String facultyName) {
		FacultyName = facultyName;
	}
	
	
}
