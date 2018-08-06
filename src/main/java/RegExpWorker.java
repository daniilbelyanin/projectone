import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpWorker {
    private String regexp, text;
    private StringBuffer processedText = new StringBuffer();
    private Pattern pattern;
    private Matcher matcher;

    public void setText(String text) {
        this.text=text;
    }

    public void setRegExp(String regexp) {
        this.regexp=regexp;
        pattern = Pattern.compile(regexp);
    }

    public String writeBackwards() {
        processedText.delete(0, processedText.length());
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            processedText.insert(0, matcher.group()+" ");
        }
        return processedText.toString();
    }

    public int howMany() {
        matcher = pattern.matcher(text);
        int count=0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
