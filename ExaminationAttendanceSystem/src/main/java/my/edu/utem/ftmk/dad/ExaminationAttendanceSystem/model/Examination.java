package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Date ExaminationDate;
	
	@Column(name = "ExaminationTime")
	private String ExaminationTime;
	
	@Column(name = "SubjectId")
	private int SubjectId;
	
	@Column(name = "LecturerId")
	private int LecturerId;
	
	@Column(name = "UnitId")
	private int UnitId;

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
		this.ExaminationDate = examinationDate;
	}

	public String getExaminationTime() {
		return ExaminationTime;
	}

	public void setExaminationTime(String examinationTime) {
		ExaminationTime = examinationTime;
	}

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	public int getLecturerId() {
		return LecturerId;
	}

	public void setLecturerId(int lecturerId) {
		LecturerId = lecturerId;
	}

	public int getUnitId() {
		return UnitId;
	}

	public void setUnitId(int unitId) {
		UnitId = unitId;
	}
	 
	
}
