package com.luxoft.projectone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpWorker {
    private String text;
    private StringBuilder processedText = new StringBuilder();
    private Pattern pattern;
    private Matcher matcher;

    public void setText(String text) {
        this.text = text;
    }

    private void setMatcher() {
        try {
            matcher = pattern.matcher(text);
        } catch (NullPointerException e) {
            System.out.println("Error while setting matcher!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    //Задаем регулярное выражение
    private void setRegExp(String regexp) {
        try {
            pattern = Pattern.compile(regexp);
        } catch (NullPointerException e) {
            System.out.println("Regular expression is null!");
            e.printStackTrace();
            System.exit(1);
        }
        setMatcher();
    }

    //Генерируем строку с обратной последовательностью
    public String writeBackwards() {
        setMatcher();
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
