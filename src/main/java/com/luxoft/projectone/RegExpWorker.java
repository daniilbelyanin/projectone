package com.luxoft.projectone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpWorker {
    private static final Logger logger = LoggerFactory.getLogger(RegExpWorker.class.getName());
    private String text;
    private StringBuilder processedText = new StringBuilder();
    private Pattern pattern;
    private Matcher matcher;

    public void setText(String text) {
        logger.info("Setting text");
        this.text = text;
    }

    private void setMatcher() {
        logger.info("Setting matcher");
        try {
            logger.debug("Matching pattern");
            matcher = pattern.matcher(text);
        } catch (NullPointerException e) {
            System.out.println("Error while matching!");
            logger.error("", e);
            e.printStackTrace();
        }
    }

    //Задаем регулярное выражение
    private void setRegExp(String regexp) {
        logger.info("Setting regexp");
        try {
            logger.debug("Compiling regexp " + regexp);
            pattern = Pattern.compile(regexp);
        } catch (NullPointerException e) {
            System.out.println("Regular expression is null!");
            logger.error("", e);
            e.printStackTrace();
        }
        setMatcher();
    }

    //Генерируем строку с обратной последовательностью
    public String writeBackwards() {
        logger.info("Writing words backwards");
        setRegExp("[^\\p{Punct}\\d\\s]+");
        processedText.delete(0, processedText.length());
        while (matcher.find()) {
            processedText.insert(0, matcher.group()+" ");
        }
        return processedText.toString().trim();
    }

    private int count() {
        int count=0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public int howManyWords() {
        setRegExp("[^\\p{Punct}\\d\\s]+");
        return count();
    }

    public int howManyPM() {
        setRegExp("\\p{Punct}");
        return count();
    }

    public int howManyLetters() {
        setRegExp("[^\\p{Punct}\\d\\s]");
        return count();
    }
}
