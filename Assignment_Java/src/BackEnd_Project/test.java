package BackEnd_Project;

import java.sql.SQLException;
import java.util.ArrayList;

public class test extends Backend {
    public test() throws SQLException, ClassNotFoundException {
        super();
    }

    public static void main(String[] args) {
//        String[] tmp = new String[50];
//        int index = 0;
//        for (int i = 0; i < 2; i++) {
//            for (char c = 'A'; c < 'Z'; c++) {
//                tmp[index] = "Nguyen" + String.valueOf(c);
//                index++;
//            }
//        }
//        for (int i = 0; i < tmp.length; i++) {
//            System.out.println(tmp[i]);
//        }

//        String[] tmp = new String[150];
//        for (int i = 0; i < 150; i++) {
//            tmp[i] = String.valueOf((i + 1));
//        }
//
//        for (int i = 0; i < tmp.length; i++) {
//            System.out.println(tmp[i]);
//        }

//        ArrayList<String> arr = new ArrayList<>();
//        int index = 0;
//        for (int i = 0; i < 20; i++) {
//            arr.add(String.valueOf(i));
//        }
//        for (int i = 0; i < 20; i++) {
//            System.out.println(arr.get(i));
//        }
//        for (int i = 0; i < 20; i++) {
//            System.out.println(arr.get(i));
//        }
//        System.out.println(arr.isEmpty());

//        int i = 0;
//        while (i != 150) {
//            System.out.println(i + 1);
//            i++;
//        }

//        int i=0;
//        int[] arr = {0,1,2,3};
//        while(i!=arr.length){
//            System.out.println(arr[i]);
//            i++;
//        }

//        Random random = new Random();
//
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
//        int i = -1;
//
//        do {
//            i = arr[random.nextInt(arr.length)];
//            System.out.println(i);
//        } while (i != arr[0]);

        try {
            Backend backEnd = new Backend();
            ArrayList<ArrayList<String>> nv = backEnd.thong_tin_phong_ban("pb001");
            for (int i = 0; i < nv.size(); i++) {
                for (int j = 0; j < nv.get(i).size(); j++) {
                    System.out.println(nv.get(i).get(j));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
