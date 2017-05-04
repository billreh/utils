package net.tralfamadore;

import java.util.HashSet;
import java.util.Set;

/**
 * Set utilities.
 * Created by wreh on 5/4/2017.
 */
public class SetUtils {
    /**
     * Return a set with all common elements of <code>set1</code> and <code>set2</code>.
     * @param set1 The first set.
     * @param set2 The second set.
     * @param <T> The type of object in the set.
     * @return A set with all common elements of <code>set1</code> and <code>set2</code>.
     */
    public static <T>Set<T> intersect(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>();

        if(set1 == null || set2 == null)
            return result;

        set1.forEach(i ->  { if(set2.contains(i)) result.add(i); });

        return result;
    }
}
