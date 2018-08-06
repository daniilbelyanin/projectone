import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EntryPoint {

    public static void main(String[] argv) throws FileNotFoundException {

        //RegExps for word, letter, punctuationMark
        String word = "[^0-9,.!;:-?\\s]+";
        String letter = "[^0-9,.!;:-?\\s]";
        String punctuationMark = "[!,;.:-?]";

        //Creating txt worker
        WorkWithTXT text = new WorkWithTXT();

        //Getting filename through input from keyboard
        Scanner readFileName = new Scanner(System.in);
        System.out.println("Please enter input text filename including extension:");
        String textFileName = readFileName.next();
        text.setInputFilename(textFileName);
        System.out.println("Please enter output text filename including extension:");
        String outputFileName = readFileName.next();
        text.setOutputFilename(outputFileName);

        //Giving text string regexpcounter
        RegExpWorker regexpcounter = new RegExpWorker();
        try {
            regexpcounter.setText(text.text2String());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Counting and printing results
        regexpcounter.setRegExp(word);
        System.out.println("Words: " + regexpcounter.howMany());
        //Printing words backwards to file
        text.string2Text(regexpcounter.writeBackwards());
        regexpcounter.setRegExp(letter);
        System.out.println("Letters: " + regexpcounter.howMany());
        regexpcounter.setRegExp(punctuationMark);
        System.out.println("Punctuation marks: " + regexpcounter.howMany());

    }
}