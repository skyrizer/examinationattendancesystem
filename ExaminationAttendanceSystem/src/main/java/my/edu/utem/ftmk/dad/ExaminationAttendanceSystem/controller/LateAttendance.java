package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.controller;

public class LateAttendance extends Exception {

	public LateAttendance()
	{
		super();
	}
	
	public void printNotification() 
	{
		System.out.println("You are considered late!");
	}
}
