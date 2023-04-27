package org.example;

import javax.swing.*;

public class NSecondExecutor extends Thread {
    private boolean running = true;
    private int secondsQuantity;
    private String message;
    private long startTime = System.currentTimeMillis();
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
//        JComponent form1 = new MainForm.JComponent;

        while (running) {

            try {
                sleep(this.secondsQuantity * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (mode) {
                System.out.println(this.message + (System.currentTimeMillis() - startTime)/1000 + " секунд");
            } else {
                System.out.println(this.message + secondsQuantity + " секунд");
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
