package com.mudassirshahzad.algos;

import java.util.HashMap;
import java.util.Map;

public class CountOccurencesOfEachElementInArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5 ,6, 6, 6, 7, 7, 8, 9, 10, 10, 10, 10};
        Map<Integer, Integer> occurences = countOccurences(arr);
        System.out.println(occurences);
    }

    private static Map<Integer, Integer> countOccurences(int[] arr) {

        Map<Integer, Integer> occurences = new HashMap<>();
        for(int i = 0; i < arr.length; i++){

            occurences.put(arr[i], occurences.getOrDefault(arr[i], 0) + 1);
        }

        return occurences;
    }
}
