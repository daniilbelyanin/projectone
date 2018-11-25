package com.luxoft.projectone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(EntryPoint.class.getName());

    public static void main(String[] argv) throws FileNotFoundException {
        logger.info("App has started");
        Launcher launcher = new Launcher();
        logger.info("Executing launcher");
        try {
            launcher.execute();
        } catch (IOException e) {
            logger.error("", e);
            e.printStackTrace();
        }
        logger.info("App has ended its work");
    }
}