import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void add() throws Exception {
        assertEquals(0, StringCalculator.add(""));
        assertEquals(1, StringCalculator.add("1"));
        assertEquals(2, StringCalculator.add("1,1"));
        assertEquals(10, StringCalculator.add("1,2,3,4"));
        assertEquals(6, StringCalculator.add(("1\n2,3")));
        assertEquals(3, StringCalculator.add("//4\n142"));
        assertEquals(3, StringCalculator.add("//;\n1;2"));
        assertEquals(6,StringCalculator.add("//***\n1***2***3"));
        assertEquals(2, StringCalculator.add("1,1,1000,20000"));
        assertThrows(Exception.class, ()-> StringCalculator.add("-1"));
        assertEquals(6,StringCalculator.add("//[:D][%]\n1:D2%3"));
    }
}