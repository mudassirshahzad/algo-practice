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

    public static int subArraySum(int[] nums, int k) {

        // Time = O(n)
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}