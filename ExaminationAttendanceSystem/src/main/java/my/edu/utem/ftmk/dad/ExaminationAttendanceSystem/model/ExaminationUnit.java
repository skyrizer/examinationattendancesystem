package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Model Name : ExaminationUnit

@Entity
@Table(name="examinationunit")
public class ExaminationUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UnitId")
	private int UnitId;
	
	@Column(name = "UnitName")
	private String UnitName;
	
	@Column(name = "UnitAvailability")
	private boolean UnitAvailability;

	/*
	* Returns the ID of the examination unit.
	* @return The ID of the examination unit.
	*/
	public int getUnitId() {
		return UnitId;
	}

	/*
	* Sets the ID of the examination unit.
	* @param unitId The ID of the examination unit to set.
	*/
	public void setUnitId(int unitId) {
		UnitId = unitId;
	}

	/*
	* Returns the name of the examination unit.
	* @return The name of the examination unit.
	*/
	public String getUnitName() {
		return UnitName;
	}

	/*
	* Sets the name of the examination unit.
	* @param unitName The name of the examination unit to set.
	*/
	public void setUnitName(String unitName) {
		UnitName = unitName;
	}

	/*
	* Returns the availability status of the examination unit.
	* @return The availability status of the examination unit.
	*/
	public boolean isUnitAvailability() {
		return UnitAvailability;
	}

	/*
	* Sets the availability status of the examination unit.
	* @param unitAvailability The availability status of the examination unit to set.
	*/
	public void setUnitAvailability(boolean unitAvailability) {
		UnitAvailability = unitAvailability;
	}
	
}
