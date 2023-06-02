package my.edu.utem.ftmk.dad.ExaminationAttendanceSystem.model;

public class Lecturer {

	private String lecturer_id;
	private String lecturer_name;
	private String subject_id;
	private int lecturer_phone;
	private String lecturer_email;
	
	public Lecturer()
	{
	
	}
	
	public String getLecturer_id() {
		return lecturer_id;
	}
	public void setLecturer_id(String lecturer_id) {
		this.lecturer_id = lecturer_id;
	}
	public String getLecturer_name() {
		return lecturer_name;
	}
	public void setLecturer_name(String lecturer_name) {
		this.lecturer_name = lecturer_name;
	}
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	public int getLecturer_phone() {
		return lecturer_phone;
	}
	public void setLecturer_phone(int lecturer_phone) {
		this.lecturer_phone = lecturer_phone;
	}
	public String getLecturer_email() {
		return lecturer_email;
	}
	public void setLecturer_email(String lecturer_email) {
		this.lecturer_email = lecturer_email;
	}
}
