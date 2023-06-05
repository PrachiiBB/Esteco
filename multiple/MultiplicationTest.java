import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MultiplicationTest {
    @Test
    public void testEmptyString() {
        assertEquals("0", MultiplicationProgram.multiplyNumbers(""));
    }

    @Test
    public void testOneNumber() {
        assertEquals("1", MultiplicationProgram.multiplyNumbers("1"));
    }

    @Test
    public void wrong_testOneNumber() {
        assertNotEquals("2", Addition.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals("2", MultiplicationProgram.multiplyNumbers("1,2"));
    }

    @Test
    public void testUnknownNumberOfNumbers() {
        assertEquals("0", MultiplicationProgram.multiplyNumbers("0,1,2,3"));
    }

    @Test
    public void wrong_testNewlineSeparator() {
        assertNotEquals("2", MultiplicationProgram.multiplyNumbers("0\n1,2,3"));
    }

    @Test
    public void testInvalidSeparatorAtEnd() {
        assertEquals("Number expected but ',' found at position 3", MultiplicationProgram.multiplyNumbers("0,1,2,3,"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals("0", MultiplicationProgram.multiplyNumbers("//;\n0;1;2;3"));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals("Negative not allowed : -1", MultiplicationProgram.multiplyNumbers("-1,2"));
    }

}
