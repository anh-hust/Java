package Week_2;

import java.util.*;

public class Task_3 {

    public static void task3(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Put the time pass: ");
        long timePass = input.nextLong();

        Date date = new Date(timePass);

        System.out.println(date.toString());

        input.close();
    }
}
