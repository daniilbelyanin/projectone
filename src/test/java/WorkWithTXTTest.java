import com.luxoft.projectone.RegExpWorker;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class WorkWithTXTTest {
    @Test
    public void testReadFile() {
        File file;
        file = new File(this.getClass().getResource("123.txt").getPath());
        assertEquals(true, file.exists());
    }
}
