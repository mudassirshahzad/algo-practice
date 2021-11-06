package com.mudassirshahzad.algos;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray1ToNElements {

    public static void main(String[] args) {

        int[] intArray = {3, 4, 6, 8, 8, 5, 9, 6, 7};
        System.out.println(new FindDuplicatesInArray1ToNElements().findSingleDuplicate(intArray));

        int[] intArray2 = {1, 4, 4, 8, 8, 1, 5, 6, 7};
        System.out.println(new FindDuplicatesInArray1ToNElements().findMultipleDuplicates(intArray2));

    }

    public int findSingleDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]);
            if (nums[temp]<0) {
                return temp;
            }
            nums[temp]*=-1;
        }
        return -1;
    }

    public List<Integer> findMultipleDuplicates(int[] nums){

        List<Integer> outputArray = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){

            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) outputArray.add(index + 1);
            nums[index]*= -1;
        }
        return outputArray;
    }
}
