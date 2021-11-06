package com.mudassirshahzad.algos;

class Main {

    public static void main(String[] args) {
        int[] arr = {10, 11, 12, 14, 15};
//        int[] arr={7,5,6,1,4,2};
        int missingNumber = missingNumber(arr);
//        int missingNumber = missingNumber2(arr, arr.length);
        System.out.println(missingNumber);
    }

    public static int missingNumber(int[] arr) {

        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        int restSum = 0;
        for (int i = 0; i < arr.length; i++) {
            restSum += arr[i];
        }
        int missingNumber = sum - restSum;
        return missingNumber;
    }

    public static int missingNumber2(int[] arr, int length) {

        int x1 = arr[0];
        int x2 = 1;

        /* For xor of all the elements in array */
        for (int i = 1; i < length; i++)
            x1 = x1 ^ arr[i];

        /* For xor of all the elements  from 1 to length+1 */
        for (int i = 2; i <= length + 1; i++)
        {
            x2 = x2 ^ i;
        }
        return x1 ^ x2;
    }
}