package Week_2;

import java.util.*;

public class Task_4 {
	public static void main(String[] args) {
		Random random = new Random(1000);
		Random random2 = new Random(1000);
		Random random3 = new Random(10);

		for (int i = 0; i < 50; i++) {
			System.out.print(random.nextInt(100) + " ");
			if (i % 5 == 0 && i != 0) {
				System.out.println();
			}
		}
		System.out.println("\n\nWith the same seed 1000: ");
		for (int i = 0; i < 50; i++) {
			System.out.print(random2.nextInt(100) + " ");
		}
		System.out.println("\n\nWith other seed: ");
		for (int i = 0; i < 50; i++) {
			System.out.print(random3.nextInt(100) + " ");
		}
	}
}
