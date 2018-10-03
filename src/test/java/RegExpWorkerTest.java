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
        regExpWorker.setText("one two three");
        assertEquals("three two one", regExpWorker.writeBackwards());
        regExpWorker.setText("              one  two     three       ");
        assertEquals("three two one", regExpWorker.writeBackwards());
        regExpWorker.setText("one 123 two 321 three 3213321 four");
        assertEquals("four three two one", regExpWorker.writeBackwards());
        regExpWorker.setText("one \n\n\n !two.!\n three 123\n 12..four.\n\n\n\n");
        assertEquals("four three two one", regExpWorker.writeBackwards());
    }
}
