package com.mudassirshahzad.algos;

import java.util.Arrays;

public class BinarySearchImplementation {

    // Precondition : Binary Search only works on sorted arrays
    public static void main(String[] args) {

        int[] integerArray = {1, 3, 6, 8, 9, 33, 34, 35, 37, 67, 99, 105, 150};

        int position = binarySearchCustom(integerArray, 67);
        System.out.println("Position of 67 in the array is " + position);

        Arrays.sort(integerArray);
        int position2 = Arrays.binarySearch(integerArray, 67);
        System.out.println(position2);
    }

    private static int binarySearchCustom(int[] integerArray, int target) {

        if (integerArray.length == 0){
            return -1;
        }
        int left = 0;
        int right = integerArray.length - 1;

        while(left <= right) {

            int middle = (left + right) / 2;

            if (target < integerArray[middle]) {

                right = middle - 1;
            } else if (target > integerArray[middle]) {

                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

}
