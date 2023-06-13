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
	private Examination examination;

	@ManyToOne
	@JoinColumn(name = "StudentId")
	private Student student;

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

	public Examination getExamination() {
		return examination;
	}
	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public Student getStudentId() {
		return student;
	}
	public void setStudentId(Student student) {
		this.student = student;
	}
	public ExaminationAttendance() {
		super();
		ExamAttendId = -1;
		ExamAttendStatus = "";
		InputType = "";
		this.examination = new Examination();
		this.student = new Student();
	}


}
