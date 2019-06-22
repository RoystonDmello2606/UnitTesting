package AttendanceTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import Attendance.AttendanceMarker;
import Services.StudentService;

public class AttendanceMarkerTest {
	StudentService studentService;
	
	@Before
	public void setUp() throws Exception {
	studentService = Mockito.mock(StudentService.class);
	}

	@Test
	public void testMarkAttendance() {
		int id = 5;
		Mockito.when(studentService.isPresent(id)).thenReturn(true);
		
		assertEquals(true, AttendanceMarker.markAttendance(id, studentService));
	}
}
