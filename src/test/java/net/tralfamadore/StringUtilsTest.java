package net.tralfamadore;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class: StringUtilsTest
 * Created by billreh on 4/28/17.
 */
public class StringUtilsTest {
    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty("  "));
        assertTrue(StringUtils.isEmpty(""));
        assertFalse(StringUtils.isEmpty("b"));
        assertFalse(StringUtils.isEmpty("  b  "));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(StringUtils.equals(null, null));
        assertFalse(StringUtils.equals("", null));
        assertFalse(StringUtils.equals(null, ""));
        assertTrue(StringUtils.equals("", ""));
        assertTrue(StringUtils.equals("moo", "moo"));
        assertFalse(StringUtils.equals("moo", " moo"));
    }

    @Test
    public void testTrim() throws Exception {
        String s = "   s ";
        assertEquals("s", StringUtils.trim(s));
    }

    @Test
    public void testCapitalize() throws Exception {
        String s = "awOrd";
        assertEquals("AwOrd", StringUtils.capitalize(s));
    }

    @Test
    public void testUncapitalize() throws Exception {
        String s = "TheWord";
        assertEquals("theWord", StringUtils.uncapitalize(s));
    }

    @Test
    public void testToCamelCase() throws Exception {
        String s = "DB_TABLE_NAME";
        assertEquals("dbTableName", StringUtils.toCamelCase(s));
        s = "ANameOrSo";
        assertEquals("aNameOrSo", StringUtils.toCamelCase(s));
    }

    @Test
    public void testToUpperCamelCase() throws Exception {
        String s = "DB_TABLE_NAME";
        assertEquals("DbTableName", StringUtils.toUpperCamelCase(s));
        s = "aNameOrSo";
        assertEquals("ANameOrSo", StringUtils.toUpperCamelCase(s));
    }

    @Test
    public void testToDbCase() throws Exception {
        assertEquals("HELLO_THERE", StringUtils.toDbCase("helloThere"));
        assertEquals("HELLO_THERE_MR_DOG", StringUtils.toDbCase("helloThereMrDog"));
        assertEquals("HI_T", StringUtils.toDbCase("hiT"));
        assertEquals("M", StringUtils.toDbCase("m"));
        assertEquals("HELLO_THERE_MR_DOG", StringUtils.toDbCase("HelloThereMrDog"));
    }
}