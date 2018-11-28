package com.luxoft.projectone;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    private String propertyFile;
    private Properties prop = new Properties();

    public void setPropertyFile(String propertyFile) {
        this.propertyFile = propertyFile;
    }

    private void loadProperites() {
        InputStream input = null;
        try {
            input = getClass().getClassLoader().getResourceAsStream(propertyFile);
            if (input == null) {
                System.out.println("Sorry, unable to find " + propertyFile);
            }
            prop.load(input);
            input.close();
        } catch (IOException e) {
            System.out.println("Sorry, unable to find " + propertyFile);
            e.printStackTrace();
        }
    }

    public String returnProperty(String requestedProperty) {
        loadProperites();
        return prop.getProperty(requestedProperty);
    }
}
