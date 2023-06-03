package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FacultyId")
	private int Faculty_id;
	
	@Column(name = "FacultyName")
	private String faculty_name;
	
	public int getFaculty_id() {
		return Faculty_id;
	}
	public void setFaculty_id(int faculty_id) {
		Faculty_id = faculty_id;
	}
	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
}
