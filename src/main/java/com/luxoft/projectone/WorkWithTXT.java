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

    public String textFile2String() throws IOException {
        String str;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename),
                "cp1251"))) {
            str = in.readLine();
        }
        return str;
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
            toFile.close();
        } catch (IOException e) {
            System.out.println("Cant create file!");
        }
    }

    public void setInputFilename(String filename) {
        inputFilename = filename;
    }

    public void setOutputFilename(String filename) {
        outputFilename = filename;
    }

}