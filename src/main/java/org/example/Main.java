package org.example;


public class Main{
    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n Task 2:\n");
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        System.out.println(fizzBuzzProcessor.fizzBuss(15));

        Thread.sleep(4500);

        System.out.println("\n Task 1:\n");

        long startTime = System.currentTimeMillis();
        boolean running = true;
        Thread everySecondThread = new NSecondExecutor(1, "Від запуску програми минуло ", true);
        everySecondThread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread fiveSecondThread = new NSecondExecutor(5, "Минуло ще ");
        fiveSecondThread.start();




    }
}