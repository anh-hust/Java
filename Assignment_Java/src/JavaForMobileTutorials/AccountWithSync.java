package JavaForMobileTutorials;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithSync {
    private static AccountWithoutSync.Account account = new AccountWithoutSync.Account();

    public static class Account {
        private double balance;

        // TODO Synchronize the function deposit so if it is called, no others function can touch the mem it manipulates
        public synchronized void deposit(double amount) {
            this.balance += amount;
        }

        public void withdraw(double amount) {
            this.balance -= amount;
        }

        public double getBalance() {
            return this.balance;
        }
    }

    public static class AddPennyTask implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }

    }

    public static class WithdrawTask implements Runnable {
        @Override
        public void run() {
            account.withdraw(1);
        }
    }

    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(1); // still the right answer
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executor.execute(new AccountWithoutSync.AddPennyTask());
            executor.execute(new AccountWithoutSync.WithdrawTask());
        }

        executor.shutdown();

        while (!executor.isTerminated()) ;

        System.out.println(" " + account.getBalance());
    }
}
