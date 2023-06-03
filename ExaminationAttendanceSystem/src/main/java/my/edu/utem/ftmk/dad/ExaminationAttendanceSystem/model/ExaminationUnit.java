package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ExaminationUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UnitId")
	private int Unit_id;
	
	@Column(name = "UnitName")
	private String Unit_Name;
	
	@Column(name = "availability")
	private boolean Availability;
	
	public int getUnit_id() {
		return Unit_id;
	}
	public void setUnit_id(int unit_id) {
		Unit_id = unit_id;
	}
	public String getUnit_Name() {
		return Unit_Name;
	}
	public void setUnit_Name(String unit_Name) {
		Unit_Name = unit_Name;
	}
	public boolean isAvailability() {
		return Availability;
	}
	public void setAvailability(boolean availability) {
		Availability = availability;
	}
	
	
	
}
