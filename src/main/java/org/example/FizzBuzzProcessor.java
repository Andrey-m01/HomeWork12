package org.example;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzProcessor {

    public String fizzBuss(int number) {

        StringBuffer result = new StringBuffer();

        FizzBuzzThread fizzProcessor = new FizzBuzzThread((n) -> {
            if ((int) n % 3 == 0 && ((int) n % 15 != 0)) {
                result.append("fizz")
                        .append(", ");
            }
        });
        FizzBuzzThread buzzProcessor = new FizzBuzzThread((n) -> {
            if ((int) n % 5 == 0 && ((int) n % 15 != 0)) {
                result.append("buzz")
                        .append(", ");
            }
        });
        FizzBuzzThread fizzBuzzProcessor = new FizzBuzzThread((n) -> {
            if ((int) n % 15 == 0) {
                result.append("fizzbuzz")
                        .append(", ");
            }
        });
        FizzBuzzThread defaultProcessor = new FizzBuzzThread((n) -> {
            if ((int) n % 5 != 0 && (int) n % 3 != 0) {
                result.append(n)
                        .append(", ");
            }
        });

        List<FizzBuzzThread> threads = new ArrayList<>();
        threads.add(fizzBuzzProcessor);
        threads.add(fizzProcessor);
        threads.add(buzzProcessor);
        threads.add(defaultProcessor);


        for (FizzBuzzThread thread : threads) {
            thread.start();
        }

        for (int i = 1; i < number + 1; i++) {
            for (FizzBuzzThread thread : threads) {
                thread.process(i);
            }
            while (true) {
                int processedCount = 0;
                for (FizzBuzzThread thread : threads) {
                    if (thread.getIsProcessed().get()) {
                        processedCount++;
                    }
                }
                if (processedCount == threads.size()) {
                    break;
                }
            }
        }

        for (FizzBuzzThread thread : threads) {
            thread.setThisThreadRunning(false);
        }

        result.setLength(result.length() - 2);
        return result.toString();
    }
}