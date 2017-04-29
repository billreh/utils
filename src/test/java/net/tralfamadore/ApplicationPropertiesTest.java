package net.tralfamadore;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Class: ApplicationPropertiesTest
 * Created by billreh on 4/28/17.
 */
public class ApplicationPropertiesTest {
    @Test
    public void testApplicationProperties() {
        ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
        Optional<String> property = applicationProperties.getProperty("stringTest");
        assertTrue(property.isPresent());
        assertEquals("hello", property.get());
        property = applicationProperties.getProperty("notThere");
        assertFalse(property.isPresent());
        assertTrue(applicationProperties.getPropertyBoolean("booleanTestTrue"));
        assertFalse(applicationProperties.getPropertyBoolean("booleanTestFalse"));
        assertFalse(applicationProperties.getPropertyBoolean("booleanTestNonsense"));
        assertFalse(applicationProperties.getPropertyBoolean("booleanTestNotThere"));
    }
}