import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpCounter {
    private String regexp, text;

    public void setText(String text) {
        this.text=text;
    }

    public void setRegExp(String regexp) {
        this.regexp=regexp;
    }

    public int count() {
        Pattern pattern;
        pattern = Pattern.compile(regexp);
        Matcher matcher;
        matcher = pattern.matcher(text);

        int count=0;

        while (matcher.find()) count++;

        return count;
    }
}
