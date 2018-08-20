package com.luxoft.projectone;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Launcher {

    public void execute() throws IOException {

        String filename;

        WorkWithTXT txtworker = new WorkWithTXT();
        RegExpWorker regexpcounter = new RegExpWorker();

        Scanner readFileName = new Scanner(System.in);
        do {
            System.out.println("Please enter input text filename including extension(example: C:\\folder\\text.txt):");
            filename = readFileName.nextLine();
        } while (!txtworker.ifFileExists(filename));

        txtworker.setInputFilename(filename);
        regexpcounter.setText(txtworker.textFile2String());
        System.out.println("Please enter output text filename including extension(example: C:\\folder\\text2.txt):");
        txtworker.setOutputFilename(readFileName.nextLine());

        regexpcounter.setText(txtworker.textFile2String());
        System.out.println("Words: " + regexpcounter.howManyWords());
        txtworker.string2TextFile(regexpcounter.writeBackwards());
        System.out.println("Letters: " + regexpcounter.howManyLetters());
        System.out.println("Punctuation marks: " + regexpcounter.howManyPM());
    }
}
