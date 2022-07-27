package Week_1;

import java.util.*;

public class WeekOne {

    public static void main(String[] args) {

        /**
         * Task 1
         */
		double x1, y1, radius1;
		double x2, y2, radius2;

		System.out.println("Nhap toa do diem 1 (x1, y1) va diem 2 (x2, y2)");

		Scanner input = new Scanner(System.in);
		System.out.println("Nhap toa do x1: ");
		x1 = input.nextDouble();
		System.out.println("Nhap toa do y1: ");
		y1 = input.nextDouble();
		System.out.println("Nhap toa do x2: ");
		x2 = input.nextDouble();
		System.out.println("Nhap toa do y2: ");
		y2 = input.nextDouble();

		double distance = Math.pow(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2), 0.5);


		/**
		 * Task 2
		 */
		System.out.println("Distance: " + distance);


		/**
		 * Task 3
		 */
		System.out.println("Nhap ban kinh duong tron 1: ");
		radius1 = input.nextDouble();
		System.out.println("Nhap ban kinh duong tron 2: ");
		radius2 = input.nextDouble();

		if (distance <= radius1 - radius2)
			System.out.println("Duong trton 2 inside duong tron 1");
		else if (distance <= radius1 + radius2)
			System.out.println("Duong tron 1 giao duong tron 2");
		else if (distance > radius1 + radius2)
			System.out.println("2 duong tron nam doc lap");
		else
			System.out.println("Duong tron 2 nam ngoai duong tron 1");


		input.close();

	}
}
