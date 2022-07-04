package Week_9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Ex3 {
	public static void ex3(String[] args) throws IOException {

		/**
		 * Bai 3
		 */
		File file = new File("Ex3.dat");
		Random random = new Random();
		byte[] byteArr = new byte[150];
		random.nextBytes(byteArr);

		/* if file exist --> write 150 random-byte numbers */
		if (file.exists()) {
			try {
				System.out.println("File exist !!!");
				FileOutputStream fileOutputStream = new FileOutputStream(file, true);
				for (int i = 0; i < 150; i++) {
					fileOutputStream.write(byteArr[i]);
				}
				fileOutputStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else { // else create new file
			System.out.println("New file is creating ...");
			System.out.println("Created: " + file.createNewFile());
		}

		/* read file */
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			System.out.println("The number of number: " + fileInputStream.available());
			for (int i = 0; i < fileInputStream.available(); i++) {
				System.out.print(" " + fileInputStream.read());
			}
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
