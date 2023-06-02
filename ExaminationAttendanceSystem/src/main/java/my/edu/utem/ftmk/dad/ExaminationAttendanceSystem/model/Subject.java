package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import java.util.List;
import java.util.ArrayList;

public class Subject {

	private String id;
	private String Name;
	private List<Student> students = new ArrayList<Student>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
