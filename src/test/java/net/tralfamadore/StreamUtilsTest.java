package net.tralfamadore;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Class: StreamUtilsTest
 * Created by billreh on 4/28/17.
 */
public class StreamUtilsTest {
    @Test
    public void testFilter() {
        List<String> words = Arrays.asList("here", "are", "several", "words");

        List<String> result = StreamUtils.filter(words, w -> w.length() < 4);
        assertEquals(1, result.size());
        assertEquals("are", result.get(0));

        Predicate<String> atLeastFiveChars = s -> s.length() >= 5;
        Predicate<String> startsWithS = s -> s.startsWith("s");
        result = StreamUtils.filter(words, atLeastFiveChars.and(startsWithS));
        assertEquals(1, result.size());
        assertEquals("several", result.get(0));
    }

    @Test
    public void testFilterSet() {
        Set<String> words = new HashSet<>();
        words.addAll(Arrays.asList("here", "are", "several", "words"));

        Set<String> result = StreamUtils.filter(words, w -> w.length() < 4);
        assertEquals(1, result.size());
        assertEquals("are", result.iterator().next());

        Predicate<String> atLeastFiveChars = s -> s.length() >= 5;
        Predicate<String> startsWithS = s -> s.startsWith("s");
        result = StreamUtils.filter(words, atLeastFiveChars.and(startsWithS));
        assertEquals(1, result.size());
        assertEquals("several", result.iterator().next());
    }

    @Test
    public void testMap() {
        List<String> words = Arrays.asList("here", "are", "several", "words");

        List<String> result = StreamUtils.map(words, String::toUpperCase);
        assertEquals("ARE", result.get(1));
    }

    @Test
    public void testMapSet() {
        Set<String> words = new HashSet<>();
        words.addAll(Arrays.asList("here", "are", "several", "words"));

        Set<String> result = StreamUtils.map(words, String::toUpperCase);
        assertEquals("HERE", result.iterator().next());
    }
}