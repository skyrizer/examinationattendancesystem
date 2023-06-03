package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;

public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SubjectId")
	private String SubjectId;
	@Column(name = "SubjectName")
	private String SubjectName;
	
	private List<Student> students = new ArrayList<Student>();
	
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
