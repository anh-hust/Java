package JavaForMobileTutorials;

public class Test extends APIManipulate{
    public static void main(String[] args){
//        String a = null;
//        Integer b = null;
//        float c = 0;
//        Float d = (Float) c;
//        if(d==null){
//            System.out.printf("NUll");
//        }
//        else if(d == 0){
//            System.out.println("0");
//        }
//        else{
//            System.out.println("None");
//        }

        APIManipulate.parseAPI("https://api.waqi.info/feed/here/?token=a371d994b74489020d2361991b5cf80a1743e425");
        APIManipulate.printAllValue();
    }
}
