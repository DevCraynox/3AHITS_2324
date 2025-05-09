package at.htlhl.nebenlaefigkeit;

public class Nebenlaeufigkeit {

    public Nebenlaeufigkeit() {
        Thread t1 = new Thread(new CounterRunnable(1));
        t1.start();

        Thread t2 = new Thread(new CounterRunnable(2));
        t2.start();

        // Interrupt the running Threads
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
    }

    private class CounterRunnable implements Runnable {
        int runnableId;

        public CounterRunnable (int runnableId) {
            this.runnableId = runnableId;
        }

        public void run() {
            int i = 0;

            while ((!Thread.currentThread().isInterrupted()) && i < 10) {
                i++;
                System.out.println("Thread" + runnableId + ", Counter: " + i);
                try {
                    // Thread.sleep(runnableId * 1000);
                    Thread.sleep(generateRandomTime());
                } catch (InterruptedException e) {
                    System.out.println("Thread" + runnableId + " was interrupted: " + e.getMessage());
                }
            }
        }
    }

    public static int generateRandomTime() {
        int min = 300;
        int max = 1500;
        return (int) Math.floor(Math.random()*(max-min));
    }

    public static void main(String[] args) {
        new Nebenlaeufigkeit();
    }
}