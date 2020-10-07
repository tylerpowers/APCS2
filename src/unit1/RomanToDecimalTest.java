package unit1;

import static org.junit.Assert.*;

public class RomanToDecimalTest {

    /**
     * tests ONLY the romanToDecimal() METHOD and utilizes assertEquals and assertNotEquals to determine if
     * the method is returning expected values
     */
    @org.junit.Test
    public void romanToDecimalTest() {
        assertEquals(RomanToDecimal.romanToDecimal("XIV"), 14);
        assertEquals(RomanToDecimal.romanToDecimal("MCVI"), 1106);
        assertEquals(RomanToDecimal.romanToDecimal("XXI"), 21);
        assertEquals(RomanToDecimal.romanToDecimal("DCIX"), 609);
        assertEquals(RomanToDecimal.romanToDecimal("HAHA"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("MMMCIV"), 3104);
        assertEquals(RomanToDecimal.romanToDecimal("LX"), 60);
        assertEquals(RomanToDecimal.romanToDecimal("MXXV"), 1025);
        assertEquals(RomanToDecimal.romanToDecimal("XXXIV"), 34);
        assertEquals(RomanToDecimal.romanToDecimal("DXCVI"), 596);
        assertEquals(RomanToDecimal.romanToDecimal("DXMMJKV"), -1);
        assertNotEquals(RomanToDecimal.romanToDecimal("XCIV"), 116);
        assertNotEquals(RomanToDecimal.romanToDecimal("XIX"), 21);

    }
}