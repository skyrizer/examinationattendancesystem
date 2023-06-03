package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
	private int LecturerContact;
	
	@Column(name = "LecturerEmail")
	private String LecturerEmail;
	
	public Lecturer()
	{}

	public int getLecturerId() {
		return LecturerId;
	}

	public void setLecturerId(int lecturerId) {
		LecturerId = lecturerId;
	}

	public String getLecturerName() {
		return LecturerName;
	}

	public void setLecturerName(String lecturerName) {
		LecturerName = lecturerName;
	}

	public Subject getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Subject subjectId) {
		SubjectId = subjectId;
	}

	public int getLecturerContact() {
		return LecturerContact;
	}

	public void setLecturerContact(int lecturerContact) {
		LecturerContact = lecturerContact;
	}

	public String getLecturerEmail() {
		return LecturerEmail;
	}

	public void setLecturerEmail(String lecturerEmail) {
		LecturerEmail = lecturerEmail;
	}
	
	
	
}
