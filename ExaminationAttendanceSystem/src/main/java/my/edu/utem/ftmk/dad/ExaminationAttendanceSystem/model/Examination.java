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
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
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
	
	public int getExaminationId() {
		return ExaminationId;
	}


	public void setExaminationId(int examinationId) {
		ExaminationId = examinationId;
	}
	
	public Date getExaminationDate() {
		return ExaminationDate;
	}

	public void setExaminationDate(Date examinationDate) {
		ExaminationDate = examinationDate;
	}

	public String getExaminationTime() {
		return ExaminationTime;
	}

	public void setExaminationTime(String examinationTime) {
		ExaminationTime = examinationTime;
	}
 
 


	public Lecturer getLecturer() {
		return lecturer;
	}


	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}


	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public ExaminationUnit getUnit() {
		return unit;
	}


	public void setUnit(ExaminationUnit unit) {
		this.unit = unit;
	}

	/*
	 * public String getUnitName() { return unitName; }
	 * 
	 * 
	 * public void setUnitName(String unitName) { this.unitName = unitName; }
	 */
	 
}
	