package com.luxoft.projectone;

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