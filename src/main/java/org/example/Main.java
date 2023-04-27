package org.example;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n Task 2:\n");
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        System.out.println(fizzBuzzProcessor.fizzBuss(15));

        Thread.sleep(4500);

        System.out.println("\n Task 1:\n");

        Thread everySecondThread = new NSecondExecutor(1, "Від запуску програми минуло ", true);
        everySecondThread.start();

        Thread.sleep(500);

        Thread fiveSecondThread = new NSecondExecutor(5, "Минуло ще ");
        fiveSecondThread.start();


    }
}