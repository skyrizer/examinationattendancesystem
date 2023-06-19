package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Model Name: Lecturer
@Entity
@Table(name="lecturer")
public class Lecturer {

	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LecturerId")		
	private int LecturerId;
	
	@Column(name = "LecturerName")
	private String LecturerName;
	
	@ManyToOne
	@JoinColumn(name = "SubjectId")
	private Subject SubjectId;
	
	@Column(name = "LecturerContact")
	private String LecturerContact;
	
	@Column(name = "LecturerEmail")
	private String LecturerEmail;
	 
	/*
	* Returns the ID of the lecturer.
	* @return The ID of the lecturer.
	*/
	public int getLecturerId() {
		return LecturerId;
	}

	/*
	* Sets the ID of the lecturer.
	* @param lecturerId The ID of the lecturer to set.
	*/
	public void setLecturerId(int lecturerId) {
		LecturerId = lecturerId;
	}

	/*
	* Returns the name of the lecturer.
	* @return The name of the lecturer.
	*/
	public String getLecturerName() {
		return LecturerName;
	}

	/*
	* Sets the name of the lecturer.
	* @param lecturerName The name of the lecturer to set.
	*/
	public void setLecturerName(String lecturerName) {
		LecturerName = lecturerName;
	}

	/*
	* Returns the ID of the subject.
	* @return The ID of the subject.
	*/
	public Subject getSubjectId() {
		return SubjectId;
	}

	/*
	* Sets the ID of the subject.
	* @param subjectId The ID of the subject to set.
	*/
	public void setSubjectId(Subject subjectId) {
		SubjectId = subjectId;
	}

	/*
	* Returns the contact information of the lecturer.
	* @return The contact information of the lecturer.
	*/
	public String getLecturerContact() {
		return LecturerContact;
	}

	/*
	* Sets the contact information of the lecturer.
	* @param lecturerContact The contact information of the lecturer to set.
	*/
	public void setLecturerContact(String lecturerContact) {
		LecturerContact = lecturerContact;
	}

	/*
	* Returns the email address of the lecturer.
	* @return The email address of the lecturer.
	*/
	public String getLecturerEmail() {
		return LecturerEmail;
	}

	/*
	* Sets the email address of the lecturer.
	* @param lecturerEmail The email address of the lecturer to set.
	*/
	public void setLecturerEmail(String lecturerEmail) {
		LecturerEmail = lecturerEmail;
	}
}
