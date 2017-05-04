package net.tralfamadore;

import java.util.ArrayList;
import java.util.List;

/**
 * List utility methods.
 * Created by wreh on 5/3/2017.
 */
public class ListUtils {
    /**
     * Split a list into multiple lists, each of size <code>chuckSize</code>.  The last entry in the list will be
     * between 1 and chuckSize.
     * @param <T> The type of object in the list.
     * @param list The list to split into multiple lists.
     * @param chunkSize The size of each list.
     * @return A list of lists.
     */
    public static <T> List<List<T>> partitionList(List<T> list, int chunkSize) {
        List<List<T>> results = new ArrayList<>();

        if(chunkSize < 1)
            throw new RuntimeException("chunkSize must be greater than 0");

        if(list == null) {
            return results;
        }

        for(int i = 0; i < list.size(); i += chunkSize) {
            int end = i + chunkSize > list.size() ? list.size() : i + chunkSize;
            results.add(list.subList(i, end));
        }

        return results;
    }

    /**
     * Return a list with all common elements of <code>list1</code> and <code>list2</code>.
     * @param list1 The first list.
     * @param list2 The second list.
     * @param <T> The type of object in the list.
     * @return A list of all elements common to <code>list1</code> and <code>list2</code>.
     */
    public static <T> List<T> intersect(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();

        if(list1 == null || list2 == null)
            return result;

        list1.forEach(i -> { if(list2.contains(i)) result.add(i); });

        return result;
    }
}
