import java.io.FileInputStream;
import java.io.IOException;

public class TextFile2String {

    private String filename;

    public String text2String() throws IOException {
        FileInputStream inFile = new FileInputStream(filename);
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str);
        return text;
    }

    public void setFileName(String filename) {
        this.filename=filename;
    }

}
