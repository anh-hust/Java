package Week_11;

import java.util.Random;

public class test {
    public static void main (String[] args){
        Random ran = new Random();

        int[] arr = {1, 2};

        System.out.println(arr.length);

        int i = 0;
        while(i != 2){
            i = arr[ran.nextInt(arr.length)];
            System.out.println(i);
        }
    }
}
