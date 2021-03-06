package me.suhyuk.java.logging.slf4j;

import me.suhyuk.java.logging.entities.Transfer;

import org.slf4j.MDC;

/**
 * https://www.baeldung.com/mdc-in-log4j-2-logback
 */
public class Slf4jRunnable implements Runnable {
    private Transfer tx;
    Slf4jTransferService slf4jBusinessService = new Slf4jTransferService();

    public Slf4jRunnable(Transfer tx) {
        this.tx = tx;
    }

    // 쓰레드 별로 가지는 transactionId 정보를 남기기 어려운데 MDC를 활용할 수 있다.
    public void run() {
        MDC.put("transaction.id", tx.getTransactionId());
        MDC.put("transaction.owner", tx.getSender());
        slf4jBusinessService.transfer(tx.getAmount());
        MDC.clear();
    }
}
