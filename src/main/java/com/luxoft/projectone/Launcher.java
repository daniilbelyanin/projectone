package com.luxoft.projectone;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Launcher {

    public void execute() throws IOException {

        //RegExps for word, letter, punctuationMark
        String word = "[^0-9,.!;:-?\\s]+";
        String letter = "[^0-9,.!;:-?\\s]";
        String punctuationMark = "[!,;.:-?]";
        String filename;

        //Creating txt worker
        WorkWithTXT text = new WorkWithTXT();
        //Creating regexp worker
        RegExpWorker regexpcounter = new RegExpWorker();
        //Getting filenames through input from keyboard
        Scanner readFileName = new Scanner(System.in);
        do {
            System.out.println("Please enter input text filename including extension(example: C:\\folder\\text.txt):");
            filename = readFileName.nextLine();
        } while (!text.ifFileExists(filename));
        text.setInputFilename(filename);
        try {
            regexpcounter.setText(text.textFile2String());
        } catch (FileNotFoundException e) {
            System.out.println("Can't open text file!");
            System.exit(0);
        }
        System.out.println("Please enter output text filename including extension(example: C:\\folder\\text2.txt):");
        text.setOutputFilename(readFileName.nextLine());

        //Giving text string regexpcounter
        regexpcounter.setText(text.textFile2String());
        //Counting and printing results
        regexpcounter.setRegExp(word);
        System.out.println("Words: " + regexpcounter.howMany());
        //Printing words backwards to file
        text.string2TextFile(regexpcounter.writeBackwards());
        regexpcounter.setRegExp(letter);
        System.out.println("Letters: " + regexpcounter.howMany());
        regexpcounter.setRegExp(punctuationMark);
        System.out.println("Punctuation marks: " + regexpcounter.howMany());
    }
}
