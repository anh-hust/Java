package Week_10;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Ex3 {
	public static void ex3main(String[] args) {
		Random random = new Random();
		LinkedList<Object> linkedList = new LinkedList<>();

		// N
		Scanner input = new Scanner(System.in);
		int n;

		System.out.print("Enter N: ");
		n = input.nextInt();

		// add MAX VALUE integer to tail of stack so reduce trap
		linkedList.addLast(Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			int temp = random.nextInt(100);
			for (int j = 0; j < linkedList.size(); j++) {

				// ignore the same value arrange from low to high
				if (temp < (int) linkedList.get(j)) {
					linkedList.add(j, temp);
					break;
				} else if (temp == (int) linkedList.get(j))
					break;
				else
					continue;
			}
		}

		// don't count the max value we add in tail
		int size = linkedList.size() - 1;

		System.out.println("Linked List format as Stack with size: " + size + " includes:");

		// print linked list as a stack
		for (int i = size - 1; i >= 0; i--) {
			System.out.print(linkedList.get(i) + " ");
		}

		input.close();
	}
}
