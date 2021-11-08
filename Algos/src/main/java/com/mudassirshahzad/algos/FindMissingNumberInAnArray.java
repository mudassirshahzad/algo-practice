package com.mudassirshahzad.algos;

class FindMissingNumberInAnArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
//        int[] arr = {3, 4, 5, 6, 7, 2, 8, 9, 10, 11, 1, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 26};
//        int[] arr={7,5,6,1,4,2};

        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
//        int missingNumber = findMisingNumberBySumOfNaturalNumbers(arr);
        int missingNumber = findMissingNumberByXORing(arr, arr.length);
        System.out.println(missingNumber);
    }

    public static int findMisingNumberBySumOfNaturalNumbers(int[] arr) {

        // Time = O(n), Space = O(1) with Integer overflow
        int n = arr.length + 1;
        // Sum of natural numbers from 1 to n => Sn = n(n+1)/2
        int sum = n * (n + 1) / 2;
        int restSum = 0;
        for (int i = 0; i < arr.length; i++) {
            restSum += arr[i];
        }
        return sum - restSum;
    }

    static int findMissingNumberByXORing(int a[], int n){

        // Time = O(n), Space = O(1) with no overflow

        int x1 = a[0];
        int x2 = 1;

        /* For xor of all the elements
           in array */
        for (int i = 1; i < n; i++)
            x1 = x1 ^ a[i];

        /* For xor of all the elements
           from 1 to n+1 */
        for (int i = 2; i <= n + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);
    }
}