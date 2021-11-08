package com.mudassirshahzad.algos;

class Palindrome {

    public static void main(String... strings) {

//        String inputString = "aaaaaabsskkddfjffjasflkjsflkjasfljsdflkjasljsflskjfracecarslkjsdflkjjsdfkhsdflkhsdflkhasflkhasdflkjbbabbabb";
        String inputString = "raceeddffddeecar";

        boolean subString = new Palindrome().longestPalindrome(inputString);
        System.out.println("Is palindrome " + subString);

    }

    public boolean longestPalindrome(String s) {
        int strLength = s.length();
        if (strLength < 2) {
            return true;
        }

        return checkIfPalindrome(s, 0, s.length() - 1);
    }

    private boolean checkIfPalindrome(String str, int left, int right) {

        while (left <= right) {

            if(str.charAt(left) != str.charAt(right)) {
                return false;
            } else{
                left ++;
                right --;
            }
        }

        return true;
    }
}
