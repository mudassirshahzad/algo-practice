package com.mudassirshahzad.algos;

class LongestPalindromicSubstring {

    public static void main(String... strings) {

        String inputString = "aaaaaabsskkddfjffjasflkjsflkjasfljsdflkjasljsflskjfracecarslkjsdflkjjsdfkhsdflkhsdflkhasflkhasdflkjbbabbabb";
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
        for (int start = 0; start < strLength; start++) {
            expandRange(s, start, start);
//            expandRange(s, start, start + 1);
        }

        System.out.println("expandRange() called " + count + " times");
        return s.substring(resultStart, resultLength + resultStart);
    }

    int count = 0;

    private void expandRange(String str, int begin, int end) {

        count++;

        System.out.println("expandRange(str=" + str + ", begin=" + begin + ", end=" + end + ")");

        while (begin >= 0 && end < str.length() &&
                str.charAt(begin) == str.charAt(end)) {

            begin--;
            end++;
        }

        int tempResultLength = end - begin - 1;
        int tempResultStart = begin + 1;

        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }

    }
}
