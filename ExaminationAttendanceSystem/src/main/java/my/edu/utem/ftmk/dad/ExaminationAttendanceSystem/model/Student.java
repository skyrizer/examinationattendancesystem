package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StudentId")
	private int StudentId;

	@Column(name = "StudentName")
	private String StudentName;
	
	@Column(name = "StudentMatricNo")
	private String StudentMatricNo;
	
	@Column(name = "StudentSessionGroup")
	private String StudentSessionGroup;
	
	@Column(name = "StudentCourse")
	private String StudentCourse;
	
	@Column(name = "StudentContact")
	private String StudentContact;
	
	@Column(name = "StudentEmail")
	private String StudentEmail;
	
	@Column(name = "StudentYearOfStudy")
	private String StudentYearOfStudy;

	@Column(name = "FacultyId")
	private int FacultyId;
	
	@Column(name = "LecturerId")
	private int LecturerId;
	
	/*
	@Column(name = "ExaminationId")
	private int ExaminationId;
*/
	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	
	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getStudentMatricNo() {
		return StudentMatricNo;
	}

	public void setStudentMatricNo(String studentMatricNo) {
		StudentMatricNo = studentMatricNo;
	}

	public String getStudentSessionGroup() {
		return StudentSessionGroup;
	}

	public void setStudentSessionGroup(String studentSessionGroup) {
		StudentSessionGroup = studentSessionGroup;
	}

	public String getStudentCourse() {
		return StudentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		StudentCourse = studentCourse;
	}

	public String getStudentContact() {
		return StudentContact;
	}

	public void setStudentContact(String studentContact) {
		StudentContact = studentContact;
	}

	public String getStudentEmail() {
		return StudentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}

	public String getStudentYearOfStudy() {
		return StudentYearOfStudy;
	}

	public void setStudentYearOfStudy(String studentYearOfStudy) {
		StudentYearOfStudy = studentYearOfStudy;
	}

	public int getFacultyId() {
		return FacultyId;
	}

	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}

	public int getLecturerId() {
		return LecturerId;
	}

	public void setLecturerId(int lecturerId) {
		LecturerId = lecturerId;
	}
/*
	public int getExaminationId() {
		return ExaminationId;
	}

	public void setExaminationId(int examinationId) {
		ExaminationId = examinationId;
	}
	*/
	
	
	
}
