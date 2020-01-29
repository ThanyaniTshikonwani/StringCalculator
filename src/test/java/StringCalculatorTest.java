import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void addSpace() {
        assertEquals(0,StringCalculator.add(""));
    }
    @Test
    void addOneNUmber() {
        assertEquals(1,StringCalculator.add("1"));
    }
    @Test
    void addTwoNumber() {
        assertEquals(3,StringCalculator.add("1,2"));
    }

    @Test
    void addThreeNumber() {
        assertEquals(6,StringCalculator.add("1,2,3"));
    }
    @Test
    void addNewLineNumber() {
        assertEquals(6,StringCalculator.add("1\n2,3"));
    }

    @Test
    void addDelimeterNumber() {
        assertEquals(3,StringCalculator.add("//;\n1;2"));
    }

    @Test
    void addDelimeterOnNumber() {
        assertEquals(3,StringCalculator.add("//4\n142"));
    }

//    @Test
//    void addErrorNegativeNumber() {
//        assertEquals(10,StringCalculator.add("1,2,3,4"));
//    }
}