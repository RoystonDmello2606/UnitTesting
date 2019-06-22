package Lift;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number of users");
		
		Scanner sc = new Scanner(System.in);
		
		int numberUsers = sc.nextInt();
		
		System.out.println("Enter current floor");
		
		int currentFloor = sc.nextInt();
		
		ArrayList<Integer> preferences =  new ArrayList<Integer>();
		
		System.out.println(String.format(
				"Enter the floor preference of the %d users", numberUsers));
		for(int i = 0; i < numberUsers; ++i) {
			preferences.add(sc.nextInt());
		}
		
		ArrayList[] orders = LiftScheduler.schedule(preferences, currentFloor);
		
		System.out.println("Lift A");
		System.out.println(orders[0]);
		System.out.println("Lift B");
		System.out.println(orders[1]);
	}
}