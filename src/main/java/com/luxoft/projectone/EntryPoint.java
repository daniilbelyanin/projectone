package com.luxoft.projectone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EntryPoint {

    public static void main(String[] argv) throws FileNotFoundException {
        Launcher launcher = new Launcher();
        try {
            launcher.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}