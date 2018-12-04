import com.luxoft.projectone.ReadProperties;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadPropertiesTest {

    @Test
    public void testNotExistedPropertyFile() {
        ReadProperties readProperties = new ReadProperties();
        readProperties.setPropertyFile("");
        assertEquals(null, (readProperties.returnProperty("nothing")));
    }

    @Test
    public void testReadNotExistedProperty() {
        ReadProperties readProperties = new ReadProperties();
        readProperties.setPropertyFile("test.properties");
        assertEquals(null, (readProperties.returnProperty("notexisted")));
    }

    @Test
    public void testReadPropertyValue() {
        ReadProperties readProperties = new ReadProperties();
        readProperties.setPropertyFile("test.properties");
        assertEquals("1000", (readProperties.returnProperty("test1")));
    }

    @Test
    public void testNullPropertyValue() {
        ReadProperties readProperties = new ReadProperties();
        readProperties.setPropertyFile("test.properties");
        assertEquals("", (readProperties.returnProperty("test2")));
    }

    @Test
    public void testWrongFormattedPropertyValue() {
        ReadProperties readProperties = new ReadProperties();
        readProperties.setPropertyFile("test.properties");
        assertEquals("", (readProperties.returnProperty("test3")));
    }

    @Test
    public void testReadPropertyWithSpecialSymbols() {
        ReadProperties readProperties = new ReadProperties();
        readProperties.setPropertyFile("test.properties");
        assertEquals("D:\\testsomething", (readProperties.returnProperty("test4")));
    }

}
