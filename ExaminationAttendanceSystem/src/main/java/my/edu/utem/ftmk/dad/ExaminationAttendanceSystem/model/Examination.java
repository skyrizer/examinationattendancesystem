package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//Model Name: Examination

@Entity
@Table(name = "examination")
public class Examination {

	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ExaminationId")		
	private int ExaminationId;
	
	@Column(name = "ExaminationDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ExaminationDate;
	
	@Column(name = "ExaminationTime")
	private String ExaminationTime;

	@ManyToOne
	@JoinColumn(name = "LecturerId")
	private Lecturer lecturer;
	 

	@ManyToOne
	@JoinColumn(name = "SubjectId")
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name = "UnitId")
	private ExaminationUnit unit;
	
	/*
	* Returns the ID of the examination.
	* @return The ID of the examination.
	*/
	public int getExaminationId() {
		return ExaminationId;
	}

	/*
	* Sets the ID of the examination.
	* @param examinationId The ID of the examination to set.
	*/
	public void setExaminationId(int examinationId) {
		ExaminationId = examinationId;
	}
	
	/*
	* Returns the date of the examination.
	* @return The date of the examination.
	*/
	public Date getExaminationDate() {
		return ExaminationDate;
	}

	/*
	* Sets the date of the examination.
	* @param examinationDate The date of the examination to set.
	*/
	public void setExaminationDate(Date examinationDate) {
		ExaminationDate = examinationDate;
	}

	/*
	* Returns the time of the examination.
	* @return The time of the examination.
	*/
	public String getExaminationTime() {
		return ExaminationTime;
	}

	/*
	* Sets the time of the examination.
	* @param examinationTime The time of the examination to set.
	*/
	public void setExaminationTime(String examinationTime) {
		ExaminationTime = examinationTime;
	}
 
	/*
	* Returns the lecturer associated with the examination.
	* @return The lecturer associated with the examination.
	*/
	public Lecturer getLecturer() {
		return lecturer;
	}

	/*
	* Sets the lecturer associated with the examination.
	* @param lecturer The lecturer to set for the examination.
	*/
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	/*
	* Returns the subject associated with the examination.
	* @return The subject associated with the examination.
	*/
	public Subject getSubject() {
		return subject;
	}


	/*
	* Sets the subject associated with the examination.
	* @param subject The subject to set for the examination.
	*/
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/*
	* Returns the examination unit associated with the examination.
	* @return The examination unit associated with the examination.
	*/
	public ExaminationUnit getUnit() {
		return unit;
	}

	/*
	* Sets the examination unit associated with the examination.
	* @param unit The examination unit to set for the examination.
	*/
	public void setUnit(ExaminationUnit unit) {
		this.unit = unit;
	}
}
	