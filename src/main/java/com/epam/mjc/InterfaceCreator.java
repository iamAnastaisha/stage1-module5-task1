package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String str : x) {
                if (str.charAt(0) != str.toUpperCase().charAt(0) || (str.charAt(0) >= 48 && str.charAt(0) <= 57)) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int size = x.size();
            for (int i = 0; i < size; i++) {
                if (x.get(i) % 2 == 0) {
                    x.add(x.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> values_new  = new ArrayList<>();
            for (String value : values) {
                if (value.charAt(0) == value.toUpperCase().charAt(0)
                        && value.charAt(value.length() - 1) == '.'
                        && value.split(" ").length > 3) {
                    values_new.add(value);
                }
            }
            return values_new;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> res = new HashMap<>();
            for (String s : x) {
                res.put(s, s.length());
            }
            return res;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> res = new ArrayList<>();
            res.addAll(list1);
            res.addAll(list2);
            return res;
        };
    }

}