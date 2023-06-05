import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AdditionTest {
    @Test
    public void testEmptyString() {
        assertEquals("0", Addition.add(""));
    }

    @Test
    public void testOneNumber() {
        assertEquals("1", Addition.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals("3", Addition.add("1,2"));
    }

    @Test
    public void testUnknownNumberOfNumbers() {
        assertEquals("6", Addition.add("0,1,2,3"));
    }

    @Test
    public void testNewlineSeparator() {
        assertEquals("6", Addition.add("0\n1,2,3"));
    }

    @Test
    public void testInvalidSeparatorAtEnd() {
        assertEquals("Number expected but ',' found at position 3", Addition.add("0,1,2,3,"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals("6", Addition.add("//;\n0;1;2;3"));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals("Negative not allowed : -1", Addition.add("-1,2"));
        assertEquals("Negative not allowed : -4, -5", Addition.add("2,-4,-5"));
    }

    @Test
    public void testMultipleErrors() {
        assertEquals("Negative not allowed : -1\nNumber expected but ',' found at position 3\nNegative not allowed : -2", Addition.add("-1,,2"));
    }
}
