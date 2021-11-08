package com.mudassirshahzad.algos;

class LongestPalindromicSubstring {

    public static void main(String... strings) {

        String inputString = "aaaaaabsskkddfjffjasflkjsflkjasfljsdflkjasljsflskjfracecarslkjaabdraceecardbaasdflkjjsdfkhsdflkhsdflkhasflkhasdflkjbbabbabb";
//        String inputString = "bracecard";

        String subString = new LongestPalindromicSubstring().longestPalindrome(inputString);
        System.out.println("Longest palindromic substring = " + subString);
    }

    int resultStart;
    int resultLength;

    public String longestPalindrome(String s) {
        int strLength = s.length();
        if (strLength < 2) {
            return s;
        }

        // Iterate through the string and check whether each character is a possible center of a possible palindrome
        for (int i = 0; i < strLength; i++) {
            expandFromMiddle(s, i, i);
            expandFromMiddle(s, i, i + 1);
        }

        return s.substring(resultStart, resultLength + resultStart);
    }

    private void expandFromMiddle(String str, int left, int right) {

        while (left >= 0 && right < str.length() &&
                str.charAt(left) == str.charAt(right)) {

            left--;
            right++;
        }

        if (resultLength < right - left - 1) {
            resultLength = right - left - 1;
            resultStart = left + 1;
        }

    }
}
