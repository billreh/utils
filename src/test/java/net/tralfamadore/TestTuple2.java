package net.tralfamadore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class: TestTuple2
 * Created by billreh on 12/23/16.
 */
public class TestTuple2 {
    @Test
    public void testTuple2() throws Exception {
        Tuple2<String,Integer> tuple1 = new Tuple2<>("Hello", 42);
        assertEquals(tuple1.getValue1(), "Hello");
        assertTrue(tuple1.getValue2() == 42);
    }
}
