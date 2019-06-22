package Attendance;

import Services.StudentService;

public class AttendanceMarker {
	public static boolean markAttendance(int id, StudentService studentService) {
	
		if(studentService.isPresent(id)) {
			return true;
		}
		else {
			return false;
		}
	}
}
