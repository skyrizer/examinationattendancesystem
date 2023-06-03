package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

public interface AttendanceInput {
	public void generateAttendanceInput(LateAttendance lateAttendace);
	// or public LateAttendance someMethod();
	
	public boolean validateAttendanceInput();
}
