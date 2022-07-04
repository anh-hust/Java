package Week_2;

import java.util.Scanner;

public class Main {
	static int elapsedTime;

	public static void taskSW(String[] args) {
		
		/**
		 * Test Stop watch
		 * */
		Stopwatch stopWatch = new Stopwatch();

		Scanner input = new Scanner(System.in);
		byte choice;
		do {
			System.out.println("Current Start Time: " + stopWatch.getStartTime());
			System.out.println("Current End Time: " + stopWatch.getEndTime());
			System.out.print("\n1. Start" + "\n2. Stop" + "\n3. Get elapsedTime (can stop or not)" + "\n0. Exit program"
					+ "\n\nChoice: ");
			choice = input.nextByte();

			switch (choice) {
			case 1:
				stopWatch.start();
				System.out.println("Start at " + stopWatch.getStartTime());
				break;
			case 2:
				stopWatch.stop();
				System.out.println("End at " + stopWatch.getEndTime());
				break;
			case 3:
				System.out.println("Elapsed time: " + stopWatch.getElapsedTime());
				break;
			case 0:
				break;
			}
		} while (choice != 0);

		input.close();
	}
}
