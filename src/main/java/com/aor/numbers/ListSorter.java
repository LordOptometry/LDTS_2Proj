package com.aor.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An utility class to sort list of numbers.
 */
public class ListSorter implements GenericListSorter {
    /**
     * Really stupid way to sort a list.
     * @return A sorted version of the list.
     */

    public List<Integer> sort(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>();
        List<Integer> sorted2 = new ArrayList<>();

        for(int number: list)
            sorted.add(number);

        int point = 0;
        int min;
        while(sorted.size() != 0) {
            min = sorted.get(0);
            for (int i = 0; i < sorted.size(); i++) {
                if (sorted.get(i) <= min) {
                    min = sorted.get(i);
                    point = i;
                }
            }
            sorted2.add(min);
            sorted.remove(point);
        }
        return sorted2;
    }
}
