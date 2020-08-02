package com.mudassirshahzad.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OptimalUtilization {

    // Problem statement - src/main/resources/OptimalUtilization.md
    /*
     * Correct Output for this class should be
     * --------------------
     * [2, 1]
     * --------------------
     * [2, 4]
     * [3, 2]
     * --------------------
     * [3, 1]
     * --------------------
     * [1, 3]
     * [3, 2]
     */

    public static void main(String... strings) {

        System.out.println("\n--------------------\n");

        runFirstCase();

        System.out.println("\n--------------------\n\n");

        runSecondCase();

        System.out.println("\n--------------------\n");

        runThirdCase();

        System.out.println("\n--------------------\n");

        runFourthCase();

    }

    static private void runFirstCase() {

        int[] aFirstElement = { 1, 2 };
        int[] aSecondElement = { 2, 4 };
        int[] aThirdElement = { 3, 6 };
        List<int[]> a = Arrays.asList(aFirstElement, aSecondElement, aThirdElement);

        int bFirstElement[] = { 1, 2 };
        List<int[]> b = Arrays.asList(bFirstElement);

        int target = 7;

        List<int[]> result = getPairs(a, b, target);

        result.stream().map(element -> Arrays.toString(element)).forEach(System.out::println);
    }

    static private void runSecondCase() {

        int[] aFirstElement = { 1, 3 };
        int[] aSecondElement = { 2, 5 };
        int[] aThirdElement = { 3, 7 };
        int[] aFourthElement = { 4, 10 };
        List<int[]> a = Arrays.asList(aFirstElement, aSecondElement, aThirdElement, aFourthElement);

        int[] bFirstElement = { 1, 2 };
        int[] bSecondElement = { 2, 3 };
        int[] bThirdElement = { 3, 4 };
        int[] bFourthElement = { 4, 5 };
        List<int[]> b = Arrays.asList(bFirstElement, bSecondElement, bThirdElement, bFourthElement);

        int target = 10;

        List<int[]> result = getPairs(a, b, target);

        result.stream().map(element -> Arrays.toString(element)).forEach(System.out::println);
    }

    static private void runThirdCase() {

        int[] aFirstElement = { 1, 8 };
        int[] aSecondElement = { 2, 7 };
        int[] aThirdElement = { 3, 14 };
        List<int[]> a = Arrays.asList(aFirstElement, aSecondElement, aThirdElement);

        int[] bFirstElement = { 1, 5 };
        int[] bSecondElement = { 2, 10 };
        int[] bThirdElement = { 3, 14 };
        List<int[]> b = Arrays.asList(bFirstElement, bSecondElement, bThirdElement);

        int target = 20;

        List<int[]> result = getPairs(a, b, target);

        result.stream().map(element -> Arrays.toString(element)).forEach(System.out::println);
    }

    static private void runFourthCase() {

        int[] aFirstElement = { 1, 8 };
        int[] aSecondElement = { 2, 15 };
        int[] aThirdElement = { 3, 9 };
        List<int[]> a = Arrays.asList(aFirstElement, aSecondElement, aThirdElement);

        int[] bFirstElement = { 1, 8 };
        int[] bSecondElement = { 2, 11 };
        int[] bThirdElement = { 3, 12 };
        List<int[]> b = Arrays.asList(bFirstElement, bSecondElement, bThirdElement);

        int target = 20;

        List<int[]> result = getPairs(a, b, target);

        result.stream().map(element -> Arrays.toString(element)).forEach(System.out::println);
    }

    static private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {

        // Brute force approach
        // Example
        // a = [{ 1, 3 }, { 2, 5 }, { 3, 7 }, { 4, 10 }]
        // b = [{ 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }]
        // target = 10

        Map<Integer, List<int[]>> sumMap = new HashMap<>();// key is sum , value is list of ids from a and b.

        a.stream().forEach(aElement -> {
            b.stream().forEach(bElement -> {

                int sum = aElement[1] + bElement[1];
                List<int[]> ids = sumMap.getOrDefault(sum, new ArrayList<int[]>());
                ids.add(new int[] { aElement[0], bElement[0] });
                sumMap.put(sum, ids);
            });
        });

        List<Integer> eligibleSums = sumMap.keySet()
            .stream()
            .filter(element -> element <= target)
            .collect(Collectors.toList());

        // Get the List<int[]> having maximum sum as the key, if not return empty List
        return sumMap.getOrDefault(Collections.max(eligibleSums), new ArrayList<>());
    }

}
