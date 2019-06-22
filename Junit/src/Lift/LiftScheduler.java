package Lift;
import java.util.ArrayList;
import java.util.Comparator;

public class LiftScheduler{
	public static ArrayList[] schedule(ArrayList<Integer> preferences, int currentFloor) {
		ArrayList<Integer>[] orders = new ArrayList[2];
		orders[0] = new ArrayList<Integer>();
		orders[1] = new ArrayList<Integer>();
		
		ArrayList<Integer> distances = new ArrayList<Integer>();
		
		for (Integer pref : preferences) {
			distances.add(pref - currentFloor);
		}
		
		for (int i = 0; i < distances.size(); ++i) {
			int dist = distances.get(i);
			int lift = 0;
			if (dist < 0) {
				lift = 1;
			}
			orders[lift].add(i);
		}
		
		int size_0 = orders[0].size();
		int size_1 = orders[1].size();
		
		Comparator comp = new Comparator<Integer>() {
			public int compare(Integer t1, Integer t2) {
				Integer n1 = distances.get(t1);
				Integer n2 = distances.get(t2);
				if(n1 < 0 && n2 < 0) {
					return ((Integer)Math.abs(n1)).compareTo(((Integer)Math.abs(n2)));
				} // If both are negative take absolute, otherwise prefer going down first
				return n1.compareTo(n2);
			}
		};
		
		if (size_0 != size_1) {
			int bigger = 1;
			if(size_0 > size_1) {
				bigger = 0;
			}
			
			orders[bigger].sort(comp);
			
			int diff = Math.abs(size_1 - size_0);
			
			for(int i = 0; i < diff/2; ++i) {
				int user = orders[bigger].get(0);
				orders[bigger^1].add(user); // Xoring with 1 flips 1 to 0 and vice versa
				orders[bigger].remove(0);
			}
			
			orders[bigger^1].sort(comp);
		}
		else {
			orders[0].sort(comp);
			orders[1].sort(comp);
		}
		
		return orders;
	}
}