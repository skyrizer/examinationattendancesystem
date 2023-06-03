package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Lecturer {

	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LecturerId")		
	private int lecturer_id;
	
	@Column(name = "LecturerName")
	private String lecturer_name;
	
	@ManyToOne
	@Column(name = "SubjectId")
	private Subject subject_id;
	
	@Column(name = "LecturerPhone")
	private int lecturer_phone;
	
	@Column(name = "LecturerEmail")
	private String lecturer_email;
	
	public Lecturer()
	{}
	
	public int getLecturer_id() {
		return lecturer_id;
	}
	public void setLecturer_id(int lecturer_id) {
		this.lecturer_id = lecturer_id;
	}
	public String getLecturer_name() {
		return lecturer_name;
	}
	public void setLecturer_name(String lecturer_name) {
		this.lecturer_name = lecturer_name;
	}
	public Subject getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(Subject subject_id) {
		this.subject_id = subject_id;
	}
	public int getLecturer_phone() {
		return lecturer_phone;
	}
	public void setLecturer_phone(int lecturer_phone) {
		this.lecturer_phone = lecturer_phone;
	}
	public String getLecturer_email() {
		return lecturer_email;
	}
	public void setLecturer_email(String lecturer_email) {
		this.lecturer_email = lecturer_email;
	}
}
