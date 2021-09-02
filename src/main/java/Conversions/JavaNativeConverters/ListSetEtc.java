package Conversions.JavaNativeConverters;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class ListSetEtc {

    public static <U> Function<Object, U> filterAndCast(Class<? extends U> clazz) {
        return t -> clazz.isInstance(t) ? clazz.cast(t) : null;
    }

    public static <T> Set<T> convertListToSet(List<T> list) {
        // create a set from the List
        return new HashSet<>(list);
    }
}
