package net.tralfamadore;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test ListUtils.
 * Created by wreh on 5/4/2017.
 */
public class ListUtilsTest {
    @Test
    public void testPartition() throws Exception {
        List<Integer> numbers = IntStream.range(0, 25).boxed().collect(Collectors.toList());
        List<List<Integer>> numberLists = ListUtils.partition(numbers, 10);

        // check list sizes
        assertEquals(10, numberLists.get(0).size());
        assertEquals(10, numberLists.get(1).size());
        assertEquals(5, numberLists.get(2).size());

        // check list entries
        assertEquals(0, (int)numberLists.get(0).get(0));
        assertEquals(9, (int)numberLists.get(0).get(9));
        assertEquals(10, (int)numberLists.get(1).get(0));
        assertEquals(19, (int)numberLists.get(1).get(9));
        assertEquals(20, (int)numberLists.get(2).get(0));
        assertEquals(24, (int)numberLists.get(2).get(4));

        // check that passing a null returns an empty list
        assertTrue(ListUtils.partition(null, 10).size() == 0);

        // check that it throws a RuntimeException when chunkSize is < 1
        boolean caught = false;
        try {
            ListUtils.partition(null, 0);
        } catch (RuntimeException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @Test
    public void testIntersect() throws Exception {
        List<String> list1 = Arrays.asList("one", "two", "three", "four");
        List<String> list2 = Arrays.asList("two", "four", "six", "eight");

        List<String> common = ListUtils.intersect(list1, list2);

        assertEquals(2, common.size());
        assertTrue(common.contains("two"));
        assertTrue(common.contains("four"));
    }
}
