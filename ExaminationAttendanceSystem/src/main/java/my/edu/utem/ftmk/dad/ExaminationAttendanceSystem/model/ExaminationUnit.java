package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

	public int getUnitId() {
		return UnitId;
	}

	public void setUnitId(int unitId) {
		UnitId = unitId;
	}

	public String getUnitName() {
		return UnitName;
	}

	public void setUnitName(String unitName) {
		UnitName = unitName;
	}

	public boolean isUnitAvailability() {
		return UnitAvailability;
	}

	public void setUnitAvailability(boolean unitAvailability) {
		UnitAvailability = unitAvailability;
	}
	
	
}
