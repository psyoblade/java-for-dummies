package me.suhyuk.java.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 쓰레드를 사용하여 1부터 10까지 11부터 20까지 ... 91부터 100까지 더하는 연산을 수행한다.
 * 
 * @author psyoblade
 *
 */

class Sum implements Callable<Integer> {
    int start;
    int end;
    int sum;

    public Sum(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
    }

    @Override
    public Integer call() throws Exception {
        Random sleep = new Random();
        for (int i = start; i <= end; i++) {
            sum += i;
            Thread.sleep(100 * sleep.nextInt(20));
        }
        return sum;
    }
}

public class SumOfOneToTen {
    private static final Logger logger = LoggerFactory.getLogger(SumOfOneToTen.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final int ten = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(ten);
        List<Future<Integer>> completed = new ArrayList<>();

        for (int i = 0; i < ten; i++) {
            int start = i * 10 + 1;
            int end = start + 9;
            completed.add(executorService.submit(new Sum(start, end)));
        }

        int total = 0;
        for (Future<Integer> future : completed) {
            try {
                // Future의 get 메소드는 해당 스레드의 작업이 완료될 때 까지 기다렸다가 값을 반환한다.
                int partial = future.get();
                total += partial;
                logger.info("Future result is - {} And total value is {} ", partial, total);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

}
