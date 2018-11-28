package com.luxoft.projectone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(EntryPoint.class.getName());

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        String outputfilename = "none";
        String inputfilename = "none";

        //console args
        Options options = new Options();
        options.addOption("h", "help", false, "shows help");
        options.addOption("v", "version", false, "shows version");
        Option inputfile = Option.builder()
                .longOpt("i")
                .argName("inputfile")
                .hasArg()
                .desc("defines input file (i.e. C:\\Folder\\Input.txt)")
                .build();
        Option outputfile = Option.builder()
                .longOpt("o")
                .argName("outputfile")
                .hasArg()
                .desc("defines output file (i.e. C:\\Folder\\Input.txt)")
                .build();
        options.addOption(inputfile);
        options.addOption(outputfile);

        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.getOptions().length == 0) {
            System.out.println("At least one argument must be specified!");
            formatter.printHelp("args", options);
            System.exit(1);
        }

        if (cmd.hasOption("h")) formatter.printHelp("args", options);
        //Пока не стал писать отдельную функцию на выдирание версии из манифеста
        if (cmd.hasOption("v")) System.out.println("Current version: 1.0");
        if (cmd.hasOption("i") & cmd.getOptionValue("i") != null) inputfilename = cmd.getOptionValue("i");
        if (cmd.hasOption("o") & cmd.getOptionValue("o") != null) outputfilename = cmd.getOptionValue("o");


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