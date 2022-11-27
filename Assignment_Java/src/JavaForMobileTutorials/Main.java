package JavaForMobileTutorials;

public class Main {
    public static void main(String[] args) {
        Runnable printA = new Print('a', 100);
        Print printNumber = new Print(12.4, 100);
        Print printB = new Print('b', 100);

        /*Create Thread for task Print*/
        Thread threadPrintA = new Thread(printA);
        Thread threadPrintB = new Thread(printB);
        Thread threadPrintNumber = new Thread(printNumber);

        threadPrintB.setPriority(1);
        threadPrintA.setPriority(10);
        threadPrintNumber.setPriority(1);

        /*Run the thread without any scheduling*/
        threadPrintA.start();
        threadPrintB.start();
//        for (int i = 0; i < 100; i++) {
//            System.out.print(" " + i);
//            if (i == 50) {
//                try {
//                    threadPrintB.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        threadPrintNumber.start();

        /*Check thread out*/
        System.out.println("Thread Print A is: " + threadPrintA
                .isAlive());
        System.out.println("Thread Print B is: " + threadPrintB
                .isAlive());
        System.out.println("Thread Print Number is: " + threadPrintNumber
                .isAlive());
    }
}
