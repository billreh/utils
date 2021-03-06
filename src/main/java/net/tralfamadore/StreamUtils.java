package net.tralfamadore;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class: StreamUtils
 * Created by billreh on 4/28/17.
 */
public class StreamUtils {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        if(list == null)
            return Collections.emptyList();
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static <T> Set<T> filter(Set<T> list, Predicate<T> predicate) {
        if(list == null)
            return Collections.emptySet();
        return list.stream().filter(predicate).collect(Collectors.toCollection(HashSet::new));
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> function) {
        if(list == null)
            return Collections.emptyList();
        return list.stream().map(function).collect(Collectors.toList());
    }

    public static <T,R> Set<R> map(Set<T> list, Function<T,R> function) {
        if(list == null)
            return Collections.emptySet();
        return list.stream().map(function).collect(Collectors.toCollection(HashSet::new));
    }
}
