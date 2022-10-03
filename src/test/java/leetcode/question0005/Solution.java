package leetcode.question0005;

public class Solution {

    public static void main(String[] args) {
        String longestPalindrome = longestPalindrome("acbaababd");
        System.out.println(longestPalindrome);
    }

    // Brute Force, Time Complexity - O(n^3)
    public static String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        int len = s.length();
        if (len <= 1) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && isPalindromic(charArr, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    private static boolean isPalindromic(char[] charArr, int start, int end) {
        while (start < end) {
            if (charArr[start++] != charArr[end--]) {
                return false;
            }
        }
        return true;
    }
}
