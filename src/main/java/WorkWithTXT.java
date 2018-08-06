import java.io.*;

public class WorkWithTXT {

    private String inputFilename, outputFilename;
    private String path="./src/main/resources/";

    public String text2String() throws IOException {
        FileInputStream fromFile = new FileInputStream(path + inputFilename);
        byte[] str = new byte[fromFile.available()];
        fromFile.read(str);
        return new String(str);
    }

    public void string2Text(String text) throws FileNotFoundException {
        File file = new File(path + outputFilename);
        try (FileOutputStream toFile = new FileOutputStream(file)) {
            if (!file.exists()) {
                file.createNewFile();
        }
            byte[] contentInBytes = text.getBytes();

            toFile.write(contentInBytes);
            toFile.flush();
            toFile.close();

    } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setInputFilename(String filename) {
        inputFilename = filename;
    }

    public void setOutputFilename(String filename) {
        outputFilename = filename;
    }

}