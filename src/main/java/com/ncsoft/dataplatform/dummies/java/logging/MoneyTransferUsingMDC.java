package com.ncsoft.dataplatform.dummies.java.logging;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ncsoft.dataplatform.dummies.java.logging.entities.TransactionFactory;
import com.ncsoft.dataplatform.dummies.java.logging.entities.Transfer;
import com.ncsoft.dataplatform.dummies.java.logging.log4j.Log4jRunnable;
import com.ncsoft.dataplatform.dummies.java.logging.slf4j.Slf4jRunnable;

public class MoneyTransferUsingMDC {
    private static final Logger logger = LoggerFactory.getLogger(MoneyTransferUsingMDC.class);

    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "slf4j";
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            Transfer tx = TransactionFactory.newInstance();
            Runnable task = (name.equals("log4j")) ? new Log4jRunnable(tx) : new Slf4jRunnable(tx);
            executor.submit(task);
            logger.info("Submit {} {} task using executor service.", i, name);
        }
        executor.shutdown();

    }

}
