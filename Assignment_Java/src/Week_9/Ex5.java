package Week_9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Ex5 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/**
		 * Bai 5
		 */
		int[] numbers = { 1, 2, 3, 4, 5 };

		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Ex5.dat", true));

		output.writeObject(numbers);
		output.writeObject(new Date());
		output.writeDouble(5.5);

		output.close();
	}
}
