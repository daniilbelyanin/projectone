package com.luxoft.projectone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class WorkWithTXT {

    private String inputFilename, outputFilename;
    private static final Logger logger = LoggerFactory.getLogger(WorkWithTXT.class.getName());

    public boolean ifFileExists(String path) {
        logger.info("Checking file existance");
        logger.debug("Checking file " + path + " exists");
        if ((new File(path)).isFile()) {
            return true;
        } else {
            System.out.println("File not found!");
            return false;
        }
    }

    public boolean checkFileSize(String filename) {

        ReadProperties readProperties = new ReadProperties();
        readProperties.setPropertyFile("settings.properties");
        boolean check = true;

        if (ifFileExists(filename) == true) {
            File file = new File(filename);
            try {
                if (file.length() > Integer.parseInt(readProperties.returnProperty("maxInputFilesize"))) {
                    switch (Locale.getDefault().toString()) {
                        case "en_US":
                            System.out.println("Input file size is too big!");
                            break;
                        case "ru_RU":
                            System.out.println("Обрабатываемый файл слишком большой!");
                            break;
                    }
                    check = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Read property is not a number!");
                logger.error("Read property is not a number!");
            }
        }
        return check;
    }

    public String textFile2String() {
        StringBuilder str = new StringBuilder();
        String line;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename), "cp1251"))) {
            try {
                while ((line = in.readLine()) != null) {
                    str.append(line + "\n");
                }
                if (str.length() > 0) str.delete(str.length() - 1, str.length());
            } catch (IOException e) {
                System.out.println("Input\\output exception!");
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported file encoding! ");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("File not found! ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Input\\output exception!");
            e.printStackTrace();
        }
        return str.toString();
    }

    public void string2TextFile(String text) {
        logger.info("Converting string to text file");
        File file = new File(outputFilename);
        logger.debug("Creating file " + outputFilename);
        try (FileOutputStream toFile = new FileOutputStream(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] contentInBytes = text.getBytes();

            toFile.write(contentInBytes);
            toFile.flush();
        } catch (IOException e) {
            System.out.println("Cant create file!");
            logger.error("", e);
            e.printStackTrace();
        }
    }

    public void setInputFilename(String filename) {
        logger.info("Setting input filename");
        inputFilename = filename;
        logger.debug("inputFileName was set to " + filename);
    }

    public void setOutputFilename(String filename) {
        logger.info("Setting output filename");
        outputFilename = filename;
        logger.debug("outputFileName was set to " + outputFilename);
    }
}