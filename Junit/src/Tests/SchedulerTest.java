package Tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import Lift.LiftScheduler;
import jdk.jfr.SettingDefinition;
import junit.framework.TestCase; 

public class SchedulerTest extends TestCase {
	ArrayList[] expected1;
	ArrayList[] expected2;
	
	ArrayList<Integer> preferences1;
	ArrayList<Integer> preferences2;
	
	@Override
	protected void setUp() throws Exception {
		this.expected1 = new ArrayList[2];
		this.expected2 = new ArrayList[2];
		
		this.expected1[0] = new ArrayList<Integer>();
		this.expected1[1] = new ArrayList<Integer>();
		
		this.expected1[0].addAll(Arrays.asList(1,2,3));
		this.expected1[1].addAll(Arrays.asList(4,5,0));
		
		this.preferences1 = new ArrayList<Integer>(Arrays.asList(3,4,5,5,1,1));
		
		this.expected2[0] = new ArrayList<Integer>();
		this.expected2[1] = new ArrayList<Integer>();
		
		this.expected2[1].addAll(Arrays.asList(0,1,2));
		this.expected2[0].addAll(Arrays.asList(3,4,5));
		
		this.preferences2 = new ArrayList<Integer>(Arrays.asList(6,6,6,6,6,6));
	}
	
	@Test
	public void testSchedule() {
		assertArrayEquals(this.expected1, LiftScheduler.schedule(this.preferences1, 2));
		assertArrayEquals(this.expected2, LiftScheduler.schedule(this.preferences2, 0));
	}
}
