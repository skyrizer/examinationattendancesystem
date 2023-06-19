package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Model Name: Faculty

@Entity
@Table(name="faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FacultyId")
	private int FacultyId;
	
	@Column(name = "FacultyName")
	private String FacultyName;

	/*
	* Returns the ID of the faculty.
	* @return The ID of the faculty.
	*/
	public int getFacultyId() {
		return FacultyId;
	}

	/*
	* Sets the ID of the faculty.
	* @param facultyId The ID of the faculty to set.
	*/
	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}

	/*
	* Returns the name of the faculty.
	* @return The name of the faculty.
	*/
	public String getFacultyName() {
		return FacultyName;
	}

	/*
	* Sets the name of the faculty.
	* @param facultyName The name of the faculty to set.
	*/
	public void setFacultyName(String facultyName) {
		FacultyName = facultyName;
	}
}
