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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "StudentId")
	private String StudentId;
	
	@Column(name = "StudentName")
	private String StudentName;
	
	@Column
	private String Student_MatricNo;
	private String Session_Group;
	private String course;
	private String Phone_Number;
	private String email;
	private String Year_of_Study;
	private int Faculty_id;
	private String Lecturer_id;
	private int Examination_id;
	
	public String getStudent_id() {
		return StudentId;
	}
	public void setStudent_id(String student_id) {
		StudentId = student_id;
	}
	public String getName() {
		return StudentName;
	}
	public void setName(String name) {
		StudentName = name;
	}
	public String getStudent_MatricNo() {
		return Student_MatricNo;
	}
	public void setStudent_MatricNo(String student_MatricNo) {
		Student_MatricNo = student_MatricNo;
	}
	public String getSession_Group() {
		return Session_Group;
	}
	public void setSession_Group(String session_Group) {
		Session_Group = session_Group;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getYear_of_Study() {
		return Year_of_Study;
	}
	public void setYear_of_Study(String year_of_Study) {
		Year_of_Study = year_of_Study;
	}
	public int getFaculty_id() {
		return Faculty_id;
	}
	public void setFaculty_id(int faculty_id) {
		Faculty_id = faculty_id;
	}
	public String getLecturer_id() {
		return Lecturer_id;
	}
	public void setLecturer_id(String lecturer_id) {
		Lecturer_id = lecturer_id;
	}
	public int getExamination_id() {
		return Examination_id;
	}
	public void setExamination_id(int examination_id) {
		Examination_id = examination_id;
	}
	
	
}
