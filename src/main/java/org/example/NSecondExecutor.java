package org.example;


public class NSecondExecutor extends Thread {
    private final boolean running = true;
    private final int secondsQuantity;
    private final String message;
    private final long startTime = System.currentTimeMillis();
    private boolean mode;

    public NSecondExecutor(int secondsQuantity, String message) {
        this.secondsQuantity = secondsQuantity;
        this.message = message;

    }

    public NSecondExecutor(int secondsQuantity, String message, boolean mode) {
        this.secondsQuantity = secondsQuantity;
        this.message = message;
        this.mode = mode;
    }

    public void run() {

        while (running) {

            try {
                sleep(this.secondsQuantity * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (mode) {
                System.out.println(this.message + (System.currentTimeMillis() - startTime) / 1000 + " секунд");
            } else {
                System.out.println(this.message + secondsQuantity + " секунд");
            }
        }
    }
}
