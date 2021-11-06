package com.mudassirshahzad.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDistinctInEveryWindowOfSizeK {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 7, 8, 8};
        int k = 4;

        List<Integer> counts = countDistinctElements(arr, k);
        System.out.println(counts);
    }

    private static List<Integer> countDistinctElements(int[] arr, int k) {

        List<Integer> counts = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        counts.add(map.size());

        for (int i = k; i < arr.length; i++) {

            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            counts.add(map.size());
        }

        return counts;
    }
}
