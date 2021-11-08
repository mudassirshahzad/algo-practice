package com.mudassirshahzad.algos;

import java.util.Arrays;

class Find2ndLargestElementInArray {

    public static void main(String[] args) {

        int[] arr = {12, 35, 1, 10, 34, 1};
        int n = arr.length;

        print2ndlargestInNLogNTime(arr, n);

        print2ndLargestInNTime(arr, n);
    }

    static void print2ndlargestInNLogNTime(int arr[],
                                           int arr_size) {

        // Time = O(nLogn),
        int i, first, second;

        // There should be
        // atleast two elements
        if (arr_size < 2) {
            System.out.printf(" Invalid Input ");
            return;
        }

        // Takes O(nlogn)
        Arrays.sort(arr);

        // Start from second last element
        // as the largest element is at last
        // Takes O(n)
        for (i = arr_size - 2; i >= 0; i--) {
            // If the element is not
            // equal to largest element
            if (arr[i] != arr[arr_size - 1]) {
                System.out.printf("The second largest " +
                        "element is %d\n", arr[i]);
                return;
            }
        }

        System.out.printf("There is no second " +
                "largest element\n");
    }

    // Function to print the second largest elements
    static void print2ndLargestInNTime(int arr[], int arr_size) {

        // Time = O(n), Space = (1)

        int i, first, second;

        // There should be atleast two elements
        if (arr_size < 2) {
            System.out.printf(" Invalid Input ");
            return;
        }

        int largest = second = Integer.MIN_VALUE;

        // Find the largest element
        for (i = 0; i < arr_size; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Find the second largest element
        for (i = 0; i < arr_size; i++) {
            if (arr[i] != largest)
                second = Math.max(second, arr[i]);
        }
        if (second == Integer.MIN_VALUE)
            System.out.printf("There is no second " +
                    "largest element\n");
        else
            System.out.printf("The second largest " +
                    "element is %d\n", second);
    }

}