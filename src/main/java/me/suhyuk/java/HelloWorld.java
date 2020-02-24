package me.suhyuk.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    private final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public HelloWorld() {
        logger.debug("hello world initialized");
    }

    public void say() {
        logger.info("hello world");
    }

    public void goodBye() {
        logger.warn("jvm is about to end");
    }

    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        hello.say();
        hello.goodBye();
    }
}
