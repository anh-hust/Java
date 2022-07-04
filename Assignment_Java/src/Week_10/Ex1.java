package Week_10;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Ex1 {
	public static void ex1(String[] args) throws IOException {
		File file = new File("randomSymbol.txt");

		// if file exist, just read data
		if (file.exists()) {
			LinkedList<Object> linkedList = new LinkedList<>();
			System.out.println("File existed!");
			DataInputStream dataInputSream = new DataInputStream(new FileInputStream(file));

			// read char value from file
			do {

				char temp = (char) dataInputSream.readByte();

				// read a character, if different --> enQueue()
				if (temp == 'a') {
					System.out.print(temp + " ");
				} else {
					int size = linkedList.size();

					// if linked list empty --> add first
					// add 'z' in last element to avoid more trap in for loop to store value below
					if (size == 0) {
						linkedList.addFirst(temp);
						linkedList.addLast('z');
					} else if (temp == 'z')
						linkedList.addLast(temp);
					else {
						// store value into queue

						for (int i = 0; i < linkedList.size(); i++) {
							if (temp <= (char) linkedList.get(i)) {
								linkedList.add(i, temp);
								break;
							}
						}
					}
				}
			} while (dataInputSream.available() > 0);
			dataInputSream.close();

			// print queue
			// don't print the z we throw it into last element
			for (int i = 0; i < linkedList.size() - 1; i++) {
				System.out.print(linkedList.remove(i) + " ");
			}
		}

		// if file doesn't ==> just write into
		else {
			System.out.println("Create new file: " + file.createNewFile());
			FileWriter fileWriter = new FileWriter(file);
			Random random = new Random();
			for (int i = 0; i < 1000; i++) {
				fileWriter.write(random.nextInt(123 - 97) + 97);
			}
			fileWriter.close();
		}

	}
}
