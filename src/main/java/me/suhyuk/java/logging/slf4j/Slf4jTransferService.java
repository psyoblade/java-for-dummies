package me.suhyuk.java.logging.slf4j;

import me.suhyuk.java.logging.interfaces.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTransferService extends TransferService {
    private static final Logger logger = LoggerFactory.getLogger(Slf4jTransferService.class);

    @Override
    protected void beforeTransfer(long amount) {
        logger.info("Preparing to transfer ${}", amount);
    }

    @Override
    protected void afterTransfer(long amount, boolean outcome) {
        logger.info("Has transfer of ${} completed successfully ? {}", amount, outcome);
    }

}
