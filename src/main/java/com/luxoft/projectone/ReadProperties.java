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
            input = this.getClass().getResourceAsStream(propertyFile);
            if (input == null) {
                System.out.println("Sorry, unable to find " + propertyFile);
                return;
            }
            prop.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String returnProperty(String requestedProperty) {
        return prop.getProperty(requestedProperty);
    }
}
