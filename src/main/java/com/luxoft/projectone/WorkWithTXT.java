package com.luxoft.projectone;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WorkWithTXT {

    private String inputFilename, outputFilename;

    public boolean ifFileExists(String path) {
        if ((new File(path)).isFile()) {
            return true;
        } else {
            System.out.println("File does not exist!");
            return false;
        }
    }

    public String textFile2String() {
        StringBuilder str = new StringBuilder();
        String line;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename), "cp1251"))) {
            try {
                while ((line = in.readLine()) != null) {
                    str.append(line);
                }
                ;
            } catch (IOException e) {
                System.out.println("Input\\output exception!");
                e.printStackTrace();
                System.exit(1);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported file encoding! ");
            e.printStackTrace();
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.out.println("File not found! ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Input\\output exception!");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println(str);
        return str.toString();
    }

    public void string2TextFile(String text) {
        File file = new File(outputFilename);
        try (FileOutputStream toFile = new FileOutputStream(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] contentInBytes = text.getBytes();

            toFile.write(contentInBytes);
            toFile.flush();
        } catch (IOException e) {
            System.out.println("Cant create file!");
            //e.printStackTrace();
        }
    }

    public void setInputFilename(String filename) {
        inputFilename = filename;
    }

    public void setOutputFilename(String filename) {
        outputFilename = filename;
    }

}