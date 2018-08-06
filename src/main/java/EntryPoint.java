import java.io.IOException;
import java.util.Scanner;

public class EntryPoint {

    public static void main(String[] argv) {

        //RegExps for word, letter, symbol
        String word = "[^0-9,.!;:-?\\s]+";
        String letter = "[^0-9,.!;:-?\\s]";
        String symbol = "[!,;.:-?]";

        //Getting filename through input from keyboard
        Scanner readFileName = new Scanner(System.in);
        System.out.println("Please enter text filename including extension:");
        String textFileName = readFileName.next();

        TextFile2String text = new TextFile2String();
        text.setFileName(textFileName);

        RegExpCounter regexpcounter = new RegExpCounter();
        try {
            regexpcounter.setText(text.text2String());
        } catch (IOException e) {
            e.printStackTrace();
        }

        regexpcounter.setRegExp(word);
        System.out.println("Количество слов в тексте: " + regexpcounter.count());
        regexpcounter.setRegExp(letter);
        System.out.println("Количество букв в тексте: " + regexpcounter.count());
        regexpcounter.setRegExp(symbol);
        System.out.println("Количество знаков препинания: " + regexpcounter.count());

        System.out.println("\nPress ENTER to exit!");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}