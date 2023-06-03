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

@Entity
@Table(name="examinationattendance")
public class ExaminationAttendance {

	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ExamAttendId")		
	private int ExamAttendId;
	
	@Column(name = "ExamAttendStatus")		
	private String ExamAttendStatus;
	
	@Column(name = "InputType")		
	private String InputType;
	 
	@ManyToOne
	@JoinColumn(name = "ExaminationId")
	private Examination ExaminationId; 
	
	@ManyToOne
	@JoinColumn(name = "StudentId")
	private Student StudentId;
	 
	public int getExamAttendId() {
		return ExamAttendId;
	}
	public void setExamAttendId(int examAttendId) {
		ExamAttendId = examAttendId;
	}
	public String getExamAttendStatus() {
		return ExamAttendStatus;
	}
	public void setExamAttendStatus(String examAttendStatus) {
		ExamAttendStatus = examAttendStatus;
	}
	
	public String getInputType() {
		return InputType;
	}
	public void setInputType(String inputType) {
		InputType = inputType;
	}
	
	public Examination getExaminationId() {
		return ExaminationId;
	}
	public void setExaminationId(Examination examinationId) {
		ExaminationId = examinationId;
	}
	
	public Student getStudentId() {
		return StudentId;
	}
	public void setStudentId(Student studentId) {
		StudentId = studentId;
	} 
	
}
