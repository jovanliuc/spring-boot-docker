package leetcode.question0003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        int maxLength = lengthOfLongestSubstring("pwwkew");
        System.out.println(maxLength);
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        final Map<Character, Integer> map = new HashMap<>();
        int maxLength = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {

            final char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = start > map.get(c) + 1 ? start : map.get(c) + 1;
            }

            maxLength = i - start + 1 > maxLength ? i - start + 1 : maxLength;

            map.put(c, i);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        final HashSet<Character> set = new HashSet<>();
        int maxLength = 1;
        int start = 0;
        int i = 0;
        while (i < s.length()) {

            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                maxLength = set.size() > maxLength ? set.size() : maxLength;
                i ++;
            } else {
                set.remove(s.charAt(start));
                start ++;
            }
        }

        return maxLength;
    }
}
