package org.example;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class FizzBuzzThread extends Thread {

    private int number;

    public void setThisThreadRunning(boolean thisThreadRunning) {
        this.thisThreadRunning = thisThreadRunning;
    }

    private boolean thisThreadRunning = true;
    private final AtomicBoolean isProcessed = new AtomicBoolean(true);
    private final Consumer<Integer> processor;

    public FizzBuzzThread(Consumer<Integer> processor) {
        this.processor = processor;
    }

    public void process(int a) {
        this.number = a;
        isProcessed.set(false);
    }

    public AtomicBoolean getIsProcessed() {
        return isProcessed;
    }


    @Override
    public void run() {
        while (thisThreadRunning) {

            if (isProcessed.get()) {
                continue;
            }

            processor.accept(number);
            isProcessed.set(true);
        }
    }
}
