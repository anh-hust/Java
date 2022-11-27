package JavaForMobileTutorials;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args){
        /*Create thread (Runnable) pool with maximum thread run concurrent*/
//        ExecutorService executor = Executors.newFixedThreadPool(2); // 1 --> one thread in time, test with 2
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(new Print('a', 100));
        executor.execute(new Print('b', 100));
        executor.execute(new Print(2, 100));

        executor.shutdown();
    }
}
