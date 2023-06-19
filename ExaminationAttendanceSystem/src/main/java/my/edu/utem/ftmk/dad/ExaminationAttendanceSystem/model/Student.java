package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Model Name: Student

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
	* Returns the ID of the student.
	* @return The ID of the student.
	*/
	public int getStudentId() {
		return StudentId;
	}
	
	/*
	* Sets the ID of the student.
	* @param studentId The ID of the student to set.
	*/
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	
	/*
	* Returns the name of the student.
	* @return The name of the student.
	*/
	public String getStudentName() {
		return StudentName;
	}

	/*
	* Sets the name of the student.
	* @param studentName The name of the student to set.
	*/
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	/*
	* Returns the matriculation number of the student.
	* @return The matriculation number of the student.
	*/
	public String getStudentMatricNo() {
		return StudentMatricNo;
	}

	/*
	* Sets the matric number of the student.
	* @param studentMatricNo The matric number of the student to set.
	*/
	public void setStudentMatricNo(String studentMatricNo) {
		StudentMatricNo = studentMatricNo;
	}

	/*
	* Returns the session group of the student.
	* @return The session group of the student.
	*/
	public String getStudentSessionGroup() {
		return StudentSessionGroup;
	}

	/*
	* Sets the session group of the student.
	* @param studentSessionGroup The session group of the student to set.
	*/
	public void setStudentSessionGroup(String studentSessionGroup) {
		StudentSessionGroup = studentSessionGroup;
	}

	/*
	* Returns the course of the student.
	* @return The course of the student.
	*/
	public String getStudentCourse() {
		return StudentCourse;
	}

	/*
	* Sets the course of the student.
	* @param studentCourse The course of the student to set.
	*/
	public void setStudentCourse(String studentCourse) {
		StudentCourse = studentCourse;
	}

	/*
	* Returns the contact information of the student.
	* @return The contact information of the student.
	*/
	public String getStudentContact() {
		return StudentContact;
	}

	/*
	* Sets the contact information of the student.
	* @param studentContact The contact information of the student to set.
	*/
	public void setStudentContact(String studentContact) {
		StudentContact = studentContact;
	}

	/*
	* Returns the email address of the student.
	* @return The email address of the student.
	*/
	public String getStudentEmail() {
		return StudentEmail;
	}

	/*
	* Sets the email address of the student.
	* @param studentEmail The email address of the student to set.
	*/
	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}

	/*
	* Returns the year of study of the student.
	* @return The year of study of the student.
	*/
	public String getStudentYearOfStudy() {
		return StudentYearOfStudy;
	}

	/*
	* Sets the year of study of the student.
	* @param studentYearOfStudy The year of study of the student to set.
	*/
	public void setStudentYearOfStudy(String studentYearOfStudy) {
		StudentYearOfStudy = studentYearOfStudy;
	}

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
}
