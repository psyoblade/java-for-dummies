package me.suhyuk.java.logging.entities;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionFactory {

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final AtomicInteger idGenerator = new AtomicInteger();

    private TransactionFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static Transfer newInstance() {
        int transactionId = idGenerator.incrementAndGet();
        String sender = "psyoblade";
        int randomNum = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        // 10 thousands ~ 1 millions won
        Long amount = 10000L * randomNum;
        return new Transfer(transactionId, sender, amount);
    }
}
