package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Model Name: ExaminationAttendance

@Entity
@Table(name="examinationattendance")
public class ExaminationAttendance {
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ExamAttendId")
	private int ExamAttendId;

	@Column(name = "ExamAttendStatus")
	private String ExamAttendStatus;

	@Column(name = "InputType")
	private String InputType;

	@ManyToOne
	@JoinColumn(name = "ExaminationId")
	private Examination examination;

	@ManyToOne
	@JoinColumn(name = "StudentId")
	private Student student;

	/*
	* Returns the ID of the examination attendance.
	* @return The ID of the examination attendance.
	*/
	public int getExamAttendId() {
		return ExamAttendId;
	}
	
	/*
	* Sets the ID of the examination attendance.
	* @param examAttendId The ID of the examination attendance to set.
	*/
	public void setExamAttendId(int examAttendId) {
		ExamAttendId = examAttendId;
	}
	
	/*
	* Returns the status of the examination attendance.
	* @return The status of the examination attendance.
	*/
	public String getExamAttendStatus() {
		return ExamAttendStatus;
	}
	
	/*
	* Sets the status of the examination attendance.
	* @param examAttendStatus The status of the examination attendance to set.
	*/
	public void setExamAttendStatus(String examAttendStatus) {
		ExamAttendStatus = examAttendStatus;
	}

	/*
	* Returns the input type.
	* @return The input type.
	*/
	public String getInputType() {
		return InputType;
	}
	
	/*
	* Sets the input type.
	* @param inputType The input type to set.
	*/
	public void setInputType(String inputType) {
		InputType = inputType;
	}

	/*
	* Returns the examination associated with the examination attendance.
	* @return The examination associated with the examination attendance.
	*/
	public Examination getExamination() {
		return examination;
	}
	
	/*
	* Sets the examination associated with the examination attendance.
	* @param examination The examination to set for the examination attendance.
	*/
	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	/*
	* Returns the student associated with the examination attendance.
	* @return The student associated with the examination attendance.
	*/
	public Student getStudentId() {
		return student;
	}
	
	/*
	* Sets the student associated with the examination attendance.
	* @param student The student to set for the examination attendance.
	*/
	public void setStudentId(Student student) {
		this.student = student;
	}
	
	/*
	* Constructs a new ExaminationAttendance object with default values.
	*/
	public ExaminationAttendance() {
		super();
		ExamAttendId = -1;
		ExamAttendStatus = "";
		InputType = "";
		this.examination = new Examination();
		this.student = new Student();
	}
}
