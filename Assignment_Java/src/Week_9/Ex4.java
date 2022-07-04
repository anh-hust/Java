package Week_9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Ex4 {
	public static void ex4(String[] args) throws IOException {
		/**
		 * Bai 4
		 */
		DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("Ex4.dat"));
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			dataOutputStream.writeDouble(random.nextDouble());
		}
		dataOutputStream.close();

		double sum = 0;
		DataInputStream dataInputStream = new DataInputStream(new FileInputStream("Ex4.dat"));
		for (int i = 0; i < 100; i++) {
			sum += dataInputStream.readDouble();
		}
		System.out.println("Sum: " + sum);
		dataInputStream.close();
	}
}
