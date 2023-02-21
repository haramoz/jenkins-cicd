package com.dr.sattlers.bar;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        futureMethod(2);
        isGreater(1,2);
    }

    public static int futureMethod(int param) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit( () -> {
            Thread.sleep(2000);
            Random random = new Random();
            if(random.nextInt() % param == 0) {
                throw new Exception("something bad happened!");
            }
            return 1;
        });

        int result = 0;
        try {

            /*while(!future.isDone()) {
                System.out.println("Processing...");
                Thread.sleep(300);
            }*/
            result = future.get(7, TimeUnit.SECONDS);
            System.out.println("Result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Timeout, future is cancelled!");
            future.cancel(true);
        }catch (Exception e) {
            System.out.println("Exception!");
            throw new RuntimeException(e);
        } finally {
            executorService.shutdownNow();
        }

        //executorService.shutdown();
        return result;
    }

    public static boolean isGreater(int num1, int num2){
        System.out.println("num1: " + num1 + " num2:" + num2);
        var isGreater = num1 > num2;
        System.out.println("num1 is greater than num2: " + isGreater);
        return isGreater;
    }
}