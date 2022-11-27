package JavaForMobileTutorials;

public class Print implements Runnable {
    private Object toPrint;
    private int times;

    public Print(char ch, int times) {
        this.toPrint = ch;
        this.times = times;
    }

    public Print(int number, int times) {
        this.toPrint = number;
        this.times = times;
    }

    public Print(Double number, int times) {
        this.toPrint = number;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.times; i++) {
            System.out.print(" " + this.toPrint);
//            try{
//            Thread.sleep(1000);
//        }catch(InterruptedException e){
//                e.printStackTrace();
//            }

        }
    }
}
