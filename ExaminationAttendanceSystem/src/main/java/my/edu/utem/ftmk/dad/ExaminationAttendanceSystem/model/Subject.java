package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Model Name: Subject

@Entity
@Table(name="subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SubjectId")
	private String subjectId;

	@Column(name = "SubjectCode")
	private String subjectCode;

	@Column(name = "SubjectName")
	private String subjectName;

	/*
	* Returns the ID of the subject.
	* @return The ID of the subject.
	*/
	public String getSubjectId() {
		return subjectId;
	}

	/*
	* Sets the ID of the subject.
	* @param subjectId The ID of the subject to set.
	*/
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	/*
	* Returns the code of the subject.
	* @return The code of the subject.
	*/
	public String getSubjectCode() {
		return subjectCode;
	}

	/*
	* Sets the code of the subject.
	* @param subjectCode The code of the subject to set.
	*/
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	/*
	* Returns the name of the subject.
	* @return The name of the subject.
	*/
	public String getSubjectName() {
		return subjectName;
	}

	/*
	* Sets the name of the subject.
	* @param subjectName The name of the subject to set.
	*/
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
}
