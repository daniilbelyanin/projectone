package com.luxoft.projectone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class WorkWithTXT {

    private String inputFilename, outputFilename;
    private static final Logger logger = LoggerFactory.getLogger(WorkWithTXT.class.getName());

    public boolean ifFileExists(String path) {
        logger.info("Checking file existance");
        logger.debug("Checking file " + path + " exists");
        try {
            if ((new File(path)).isFile()) {
                return true;
            } else {
                System.out.println("File does not exist!");
                return false;
            }
        } catch (NullPointerException e) {
            logger.error("", e);
            System.out.println("File not found!");
            e.printStackTrace();
            return false;
        }
    }

    public String textFile2String() {
        logger.info("Converting text file to string");
        StringBuilder str = new StringBuilder();
        String line;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename), "cp1251"))) {
            try {
                while ((line = in.readLine()) != null) {
                    str.append(line + "\n");
                    logger.debug("Adding line " + line + " to stringbuilder");
                }
                if (str.length() > 0) str.delete(str.length() - 1, str.length());
            } catch (IOException e) {
                System.out.println("Input\\output exception!");
                logger.error("", e);
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported file encoding! ");
            logger.error("", e);
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("File not found! ");
            logger.error("", e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Input\\output exception!");
            logger.error("", e);
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