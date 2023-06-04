package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;


// test connection
@Entity
@Table(name="subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SubjectId")
	private String SubjectId;

	@Column(name = "SubjectCode")
	private String SubjectCode;

	@Column(name = "SubjectName")
	private String SubjectName;

	//private List<Student> students = new ArrayList<Student>();

	public String getSubjectId() {
		return SubjectId;
	}
	public void setSubjectId(String subjectId) {
		SubjectId = subjectId;
	}
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	/*
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	*/
	public String getSubjectCode() {
		return SubjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		SubjectCode = subjectCode;
	}


}
