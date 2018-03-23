package com.ncsoft.dataplatform.dummies.java.logging.log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ncsoft.dataplatform.dummies.java.logging.interfaces.TransferService;

public class Log4jTransferService extends TransferService {
    private static final Logger logger = LogManager.getLogger(Log4jTransferService.class);

    @Override
    protected void beforeTransfer(long amount) {
        logger.info("Preparing to transfer $" + amount);
    }

    @Override
    protected void afterTransfer(long amount, boolean outcome) {
        logger.info("Has transfer of $" + amount + " completed successfully ? " + outcome);
    }
}