package Week_9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Ex2 {
	public static void ex2(String[] args) {
		/**
		 * Bai 2
		 */
		Random random = new Random();
		try {
			File file = new File("Ex2.txt");

			// if (file.exist()) --> append content
			if (file.exists()) {
				System.out.println("File exist");
				FileWriter fileWriter = new FileWriter(file, true);
				fileWriter.append("\nAppend begin:\n");
				for (int i = 0; i < 150; i++)
					fileWriter.append(" " + random.nextInt(200));
				fileWriter.close();
			} else { // else create the new shit
				System.out.println("New file is creating ...");
				System.out.println(file.createNewFile());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
