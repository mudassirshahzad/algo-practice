package com.mudassirshahzad.algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ContinuousSubArraysHavingSumEqualToK {
    public static void main(String[] args) {
        int[] a = {1, 5, 7, 9, 2, 1, 1, 6};
        int k = 10;
        System.out.println("Subarray = " + Arrays.toString(findSubarray(a, k)));

        System.out.println("Number of subarrays = " + subArraySum(a, k));

    }

    public static int[] findSubarray(int[] a, int k) {

        // Time = O(n)
        int sum = 0, i = 0, j = 0;

        while (i < a.length) {
            while (j < a.length && sum < k) {
                sum += a[j++];
            }

            if (sum == k) {
                return Arrays.copyOfRange(a, i, j);
            }

            sum -= a[i++];
        }

        return null;
    }

    public static int subArraySum(int[] nums, int sum) {

        // Time = O(n)
        if (nums == null || nums.length == 0) return 0;
        int currentSum = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum == sum) {
                count++;
            }
            if (map.containsKey(currentSum - sum)) {
                count += map.get(currentSum - sum);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    public static void subArraySum2(int[] nums, int sum) {

        // Time = O(n)
        if (nums == null || nums.length == 0) System.out.println("Nums length should be greather than 0");
        int currentSum = 0;
        int start = 0;
        int end = -1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            if (map.containsKey(currentSum - sum)) {
                start = map.get(currentSum - sum) + 1;
                end = i;
                break;
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        if (end == -1) {
            System.out.println("Not found");
        } else {

            System.out.println("Start = ".concat(start + "").concat(" and End = ".concat(end + "")));
        }
    }
}