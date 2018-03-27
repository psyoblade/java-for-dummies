package com.ncsoft.dataplatform.dummies.java.logging.log4j;

import org.apache.log4j.MDC;

import com.ncsoft.dataplatform.dummies.java.logging.entities.Transfer;

public class Log4jRunnable implements Runnable {
    private Transfer tx;
    Log4jTransferService log4jBusinessService = new Log4jTransferService();

    public Log4jRunnable(Transfer tx) {
        this.tx = tx;
    }

    // 쓰레드 별로 가지는 transactionId 정보를 남기기 어려운데 MDC를 활용할 수 있다.
    public void run() {
        MDC.put("transaction.id", tx.getTransactionId());
        MDC.put("transaction.owner", tx.getSender());
        log4jBusinessService.transfer(tx.getAmount());
        MDC.clear();
    }
}
