package Week_10;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex2 {

	public static void ex2main(String[] args) {
		ArrayList<Object> arrList = new ArrayList<>();
		for (int i = 0; i < 5000000; i++) {
			arrList.add(i);
		}
		Iterator<Object> iterator = arrList.iterator();

		// estimate time to traverse array list
		long startTime = System.currentTimeMillis();
		while (iterator.hasNext()) {
			iterator.next();
		}
		long endTime = System.currentTimeMillis();

		System.out.println("Time to traverse ArrayList use Iterator: " + (endTime - startTime) + "ms");
	}

}
