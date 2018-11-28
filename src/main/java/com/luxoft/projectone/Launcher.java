package com.luxoft.projectone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class Launcher {

    private static final Logger logger = LoggerFactory.getLogger(Launcher.class.getName());

    public void execute(String inputfilename, String outputfilename) throws IOException {

        String filename;

        WorkWithTXT txtworker = new WorkWithTXT();
        RegExpWorker regexpcounter = new RegExpWorker();
        filename = inputfilename;

        Scanner readFileName = new Scanner(System.in);
        do {
            System.out.println("Current input file: " + inputfilename + ". If you want other file, please enter input text filename including extension(example: C:\\folder\\text.txt):");
            filename = readFileName.nextLine();
        } while (txtworker.ifFileExists(filename) == false || txtworker.checkFileSize(filename) == false);

        logger.debug("User entered inputfilename " + filename);

        txtworker.setInputFilename(filename);
        regexpcounter.setText(txtworker.textFile2String());
        filename = outputfilename;
        System.out.println("Current output file: " + outputfilename + ". If you want other file, please enter input text filename including extension(example: C:\\folder\\text.txt):");
        logger.debug("User entered outputfilename " + filename);
        txtworker.setOutputFilename(readFileName.nextLine());

        regexpcounter.setText(txtworker.textFile2String());
        System.out.println("Words: " + regexpcounter.howManyWords());
        txtworker.string2TextFile(regexpcounter.writeBackwards());
        System.out.println("Letters: " + regexpcounter.howManyLetters());
        System.out.println("Punctuation marks: " + regexpcounter.howManyPM());
        logger.info("Launcher has stopped");
    }
}
