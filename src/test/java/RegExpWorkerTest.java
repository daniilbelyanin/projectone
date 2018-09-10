import com.luxoft.projectone.RegExpWorker;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class RegExpWorkerTest {

    @Test
    public void testRegExCountWords() {
        RegExpWorker regExpWorker = new RegExpWorker();
        regExpWorker.setText("HibernateDataProvider>logException");
        assertEquals(2, regExpWorker.howManyWords());
        regExpWorker.setText("");
        assertEquals(0, regExpWorker.howManyWords());
        regExpWorker.setText("\n");
        assertEquals(0, regExpWorker.howManyWords());
        regExpWorker.setText("123");
        assertEquals(0, regExpWorker.howManyWords());
        regExpWorker.setText("this\nshould count\n\n\nas\n5 words");
        assertEquals(5, regExpWorker.howManyWords());
    }

    @Test
    public void testRegExCountPM() {
        RegExpWorker regExpWorker = new RegExpWorker();
        regExpWorker.setText("-?");
        assertEquals(2, regExpWorker.howManyPM());
        regExpWorker.setText("aaaaa aaaaa");
        assertEquals(0, regExpWorker.howManyPM());
        regExpWorker.setText("\n\n\n   .   \n");
        assertEquals(1, regExpWorker.howManyPM());
        regExpWorker.setText(" ");
        assertEquals(0, regExpWorker.howManyPM());
        regExpWorker.setText("!");
        assertEquals(1, regExpWorker.howManyPM());
    }

    @Test
    public void testBackwardsWriting() {
        RegExpWorker regExpWorker = new RegExpWorker();
    }

    @Test
    public void testReadFile() {
        File file;
        file = new File(this.getClass().getResource("123.txt").getPath());
        assertEquals(true, file.exists());
    }

}
