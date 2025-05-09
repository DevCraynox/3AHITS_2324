package at.htlhl.carconf;

import javafx.application.Platform;

public class CounterRunnable implements Runnable {
    private int runnableId;
    private Car model;

    public CounterRunnable (int runnableId, Car model) {
        this.runnableId = runnableId;
        this.model = model;
    }

    public void run() {
        int i = 0;

        while ((!Thread.currentThread().isInterrupted()) && i < 100) {
            i++;
            System.out.println("Thread" + runnableId + ", Counter: " + i);

            int finali = i;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    model.setType("Golf " + finali);
                }
            });
        }
    }
}
