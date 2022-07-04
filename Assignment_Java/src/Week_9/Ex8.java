package Week_9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex8 {
	public static void ex8(String[] args) throws FileNotFoundException {
		/**
		 * Bai 8
		 */

		File file = new File("Salary.txt");
		Scanner input = new Scanner(file);

		double sumSalaryAssistant = 0;
		double sumSalaryTeacher = 0;
		double sumSalaryAssociate = 0;

		int numberOfAssistant = 0;
		int numberOfTeacher = 0;
		int numberOfAssociate = 0;

		String firstName = null, lastName = null, rank = null;

		while (input.hasNext()) {
			firstName = input.next();
			lastName = input.next();
			rank = input.next();
			if (rank.equals("assistant")) {
				sumSalaryAssistant += input.nextDouble();
				numberOfAssistant += 1;
			}
			if (rank.equals("teacher")) {
				sumSalaryTeacher += input.nextDouble();
				numberOfTeacher += 1;
			}
			if (rank.equals("associate")) {
				sumSalaryAssociate += input.nextDouble();
				numberOfAssociate += 1;
			}
		}
		input.close();
		System.out.println("Has " + numberOfAssistant + " assistants" + ". Sum salary of them: " + sumSalaryAssistant);
		System.out.println("Has " + numberOfTeacher + " teachers" + ". Sum salary of them: " + sumSalaryTeacher);
		System.out.println("Has " + numberOfAssociate + " associates" + ". Sum salary of them: " + sumSalaryAssociate);

		System.out.println("Test if read till end of file: " + "\n" + firstName + " " + lastName + " " + rank);
	}
}
