package Threading.HackerPoliceThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int MAX_PASSWORD = 9999;

    public static void main(String[] args) {
        Random random  = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingThread(vault));
        threads.add(new DescendingThread(vault));
        threads.add(new PoliceThread());

        for(Thread thread:threads){
            thread.start();
        }
    }

    private static class Vault {
        private int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guess) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
            return this.password == guess;
        }
    }

    private static abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("starting " + this.getClass());
            super.start();
        }
    }

    private static class AscendingThread extends HackerThread {

        public AscendingThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = 0; guess <= MAX_PASSWORD; guess++) {
                if (vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + "guess the password" + guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingThread extends HackerThread {

        public DescendingThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = MAX_PASSWORD; guess > 0; guess--) {
                if (vault.isCorrectPassword(guess)) {
                    System.out.println(this.getClass() + " guess the password" + guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {
        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Time left "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Hacker catched");
            System.exit(0);
        }
    }
}
