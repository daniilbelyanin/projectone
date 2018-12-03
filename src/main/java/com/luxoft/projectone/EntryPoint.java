package com.luxoft.projectone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class EntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(EntryPoint.class.getName());

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        String outputfilename = "none";
        String inputfilename = "none";

        //defining cmd args
        WorkWithArguments arguments = new WorkWithArguments();
        arguments.setSimpleArgument("h", "help", "shows help");
        arguments.setSimpleArgument("v", "version", "shows version");
        arguments.setComplexArgument("i", "inputfile", "defines input file (i.e. C:\\Folder\\Input.txt)");
        arguments.setComplexArgument("o", "outputfile", "defines output file (i.e. C:\\Folder\\Output.txt)");
        arguments.setCmdArguments(args);

        if (arguments.checkValidArgs() == false) {
            System.out.println("At least one argument must be specified!");
            arguments.showHelp();
            System.exit(1);
        }

        if (arguments.checkOption("h")) arguments.showHelp();
        if (arguments.checkOption("v")) System.out.println("Current version: 1.0");
        if (arguments.checkOption("i") & arguments.returnArgValue("i") != null)
            inputfilename = arguments.returnArgValue("i");
        if (arguments.checkOption("o") & arguments.returnArgValue("o") != null)
            outputfilename = arguments.returnArgValue("o");


        logger.info("App has started");
        Launcher launcher = new Launcher();
        logger.info("Executing launcher");
        try {
            launcher.execute(inputfilename, outputfilename);
        } catch (IOException e) {
            logger.error("", e);
            e.printStackTrace();
        }
        logger.info("App has ended its work");
    }
}