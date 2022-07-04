package Week_9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex6 {
	public static void main(String[] args) throws FileNotFoundException {
		/**
		 * Bai 6
		 */
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the file need to handle: ");
		String nameOfFile = input.nextLine();
		input.close();

		// sum and average of points 
		int sum = 0;
		int count = 0;
		
		// file manipulates
		File file = new File(nameOfFile);
		Scanner input1 = new Scanner(file);
		if(file.exists()) {
			while(input1.hasNext()) {
				sum += input1.nextDouble();
				count += 1; // count how many points
			}
			input1.close();
			System.out.println("Sum: " + sum);
			System.out.println("Average: " + sum/count );
		}
		else {
			System.out.println("Wrong name file...Exit !");
		}
	}
}
