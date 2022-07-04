package Week_9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Ex7 {

    public static void ex7(String[] args) throws IOException {
        /**
         * Bai 7
         */

        String[] rank = {"assistant", "teacher", "associate"};
        Random random = new Random();

        /* file manipulate */
        File file = new File("Salary.txt");
        FileWriter writeFile = new FileWriter(file);
        double salary = 0;

        for (int i = 0; i < 1000; i++) {

            // index to choose between string array rank
            int index = random.nextInt(3);

            // set salary corresponding rank
            if (index == 0) {
                salary = (80000 - 50000) * random.nextDouble() + 50000;
            } else if (index == 1)
                salary = (110000 - 60000) * random.nextDouble() + 60000;
            else
                salary = (130000 - 75000) * random.nextDouble() + 75000;

            // write into Salary.txt
            writeFile.append("FirstName" + Integer.toString(i) + " LastName" + Integer.toString(i) + " " + rank[index]
                    + " " + Double.toString(salary) + "\n");
        }
        writeFile.close();

    }

}
