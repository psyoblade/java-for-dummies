package com.ncsoft.dataplatform.dummies.java.logging.interfaces;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TransferService {

    private static final Logger logger = LoggerFactory.getLogger(TransferService.class);

    private static final int MIN = 1;
    private static final int MAX = 10;

    public boolean transfer(long amount) {

        // connects to the remote service to actually transfer money
        int randomInt = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        boolean outcome = (randomInt % 2) == 0 ? true : false;

        beforeTransfer(amount);
        logger.info("amount sent to anonymous {}", amount);
        afterTransfer(amount, outcome);

        return true;
    }

    protected abstract void beforeTransfer(long amount);

    protected abstract void afterTransfer(long amount, boolean outcome);
}