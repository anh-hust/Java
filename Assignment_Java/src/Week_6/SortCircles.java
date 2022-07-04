package Week_6;

import java.util.*;

public class SortCircles extends Circle {
    private Circle[] cArray;

    public SortCircles(int numberOfCircle) {
        Random random = new Random();
        this.cArray = new Circle[numberOfCircle];
        for (int i = 0; i < cArray.length; i++) {
            cArray[i] = new Circle(10 * random.nextDouble());
        }
    }

    public void printInfoSCircle() {
        for (int i = 0; i < cArray.length; i++) {
            System.out.println(
                    "Radius of circle " + i + ": " + cArray[i].getRadius() + "\nIts area: " + cArray[i].getArea() + "\n");
        }
    }

    public void sortCircle() {
        Double[] radiusCricle = new Double[cArray.length];
        System.out.println("\nList of circle's radius crosses the array:");
        for (int i = 0; i < cArray.length; i++) {
            radiusCricle[i] = cArray[i].getRadius();
            System.out.println(cArray[i].getRadius());
        }
        Arrays.sort(radiusCricle);
        System.out.println("After sort: ");
        for (double i : radiusCricle) {
            System.out.println(i);
        }

    }

    public int getlength() {
        return cArray.length;
    }

}
