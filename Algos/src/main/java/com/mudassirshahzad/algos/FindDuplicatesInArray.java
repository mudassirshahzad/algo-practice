package com.mudassirshahzad.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicatesInArray {

    public static void main(String[] args) {

        int[] intArray = {3, 4, 6, 8, 8, 5, 9, 6, 7};
        System.out.println(new FindDuplicatesInArray().findDuplicates1(intArray));

        int[] intArray3 = {3, 12, 6, 80, 8, 12, 80, 5, 2, 6, 45, 45};
        System.out.println(new FindDuplicatesInArray().findDuplicates3(intArray3));

    }

    public List<Integer> findDuplicates1(int[] nums) {

        // Time = O(n^2), Space = O(1)
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length - 1; j++){
                if(nums[i] == nums[j]){
                    duplicates.add(nums[i]);
                }
            }
        }
        return duplicates;
    }

    public List<Integer> findDuplicates3(int[] nums){

        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){

            if(counts.containsKey(nums[i]) && counts.get(nums[i]) == 1){

                duplicates.add(nums[i]);
            } else{
                counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
            }
        }
        return duplicates;
    }



}
