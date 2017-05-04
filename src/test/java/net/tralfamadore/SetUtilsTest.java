package net.tralfamadore;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Test SetUtils.
 * Created by wreh on 5/4/2017.
 */
public class SetUtilsTest {
    @Test
    public void testIntersect() throws Exception {
        Set<String> set1 = new HashSet<>();
        set1.add("one");
        set1.add("two");
        set1.add("three");
        Set<String> set2 = new HashSet<>();
        set2.add("two");
        set2.add("four");
        set2.add("six");

        Set<String> common = SetUtils.intersect(set1, set2);

        assertEquals(1, common.size());
        assertEquals("two", common.iterator().next());
    }
}
