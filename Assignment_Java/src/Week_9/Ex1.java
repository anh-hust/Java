package Week_9;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex1 {
	public static void ex1(String[] args) {
		int charactersCount = 0;
		int linesCount = 0;
		int wordsCount = 0;
		try {
			FileReader readFile = new FileReader("testFile.txt");
			int symbols = readFile.read();
			
			// .read() return int value that contain the byte value, when .read() return -1
			// --> no more data to read
			while (symbols != -1) {

				// print character and space between them
				System.out.print((char) symbols + " ");
				symbols = readFile.read();
				charactersCount += 1;
			}

			File file = new File("testFile.txt");
			Scanner countWord = new Scanner(file);

			/* count words */
			while (countWord.hasNext()) {
				countWord.next();
				wordsCount += 1;
			}

			Scanner countLine = new Scanner(file);

			/* count lines */
			while (countLine.hasNextLine()) {
				countLine.nextLine();
				linesCount += 1;
			}

			System.out.println("\n\nLength: " + charactersCount);
			System.out.println("Words: " + wordsCount);
			System.out.println("Lines: " + linesCount);
			readFile.close();
			countWord.close();
			countLine.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
