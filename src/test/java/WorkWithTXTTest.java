import org.junit.Before;
import org.junit.Test;
import com.luxoft.projectone.WorkWithTXT;
import java.io.File;

import static org.junit.Assert.assertEquals;

public class WorkWithTXTTest {

    @Test
    public void testifFileExists() {
        WorkWithTXT workwithtxt = new WorkWithTXT();
        assertEquals(true, workwithtxt.ifFileExists(this.getClass().getResource("test1.txt").getPath()));
    }

    @Test
    public void testtextFile2String() {
        WorkWithTXT workwithtxt = new WorkWithTXT();
        workwithtxt.setInputFilename(this.getClass().getResource("test1.txt").getPath());
        assertEquals("Testing workwithtxt method!\nIt is so exciting!", workwithtxt.textFile2String());
        workwithtxt.setInputFilename(this.getClass().getResource("test2.txt").getPath());
        assertEquals("\n\nTesting newlines!\n   and spaces!", workwithtxt.textFile2String());
    }

    @Test
    public void teststring2TextFile() {
        WorkWithTXT workwithtxt = new WorkWithTXT();

        workwithtxt.setInputFilename(this.getClass().getResource("test1.txt").getPath());
        workwithtxt.setOutputFilename(this.getClass().getResource("output_test.txt").getPath());
        workwithtxt.string2TextFile(workwithtxt.textFile2String());
        workwithtxt.setInputFilename(this.getClass().getResource("output_test.txt").getPath());
        assertEquals("Testing workwithtxt method!\nIt is so exciting!", workwithtxt.textFile2String());

        workwithtxt.setInputFilename(this.getClass().getResource("test2.txt").getPath());
        workwithtxt.setOutputFilename(this.getClass().getResource("output_test.txt").getPath());
        workwithtxt.string2TextFile(workwithtxt.textFile2String());
        workwithtxt.setInputFilename(this.getClass().getResource("output_test.txt").getPath());
        assertEquals("\n\nTesting newlines!\n   and spaces!", workwithtxt.textFile2String());

        workwithtxt.setInputFilename(this.getClass().getResource("emptyfile.txt").getPath());
        workwithtxt.setOutputFilename(this.getClass().getResource("output_test.txt").getPath());
        workwithtxt.string2TextFile(workwithtxt.textFile2String());
        workwithtxt.setInputFilename(this.getClass().getResource("output_test.txt").getPath());
        assertEquals("", workwithtxt.textFile2String());
    }
}
