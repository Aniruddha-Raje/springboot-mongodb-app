package com.example.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestSubstring {

    private static final System.Logger logger = System.getLogger(LongestSubstring.class.getName());

    public static String lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        String longestSubstring = "";
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if (map.containsKey(currentChar)) {
                start = Math.max(map.get(currentChar) + 1, start);
            }

            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                longestSubstring = s.substring(start, end + 1);
            }

            map.put(currentChar, end);
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        String input = "abcabcdbb";
        System.out.println("The length of the longest substring without repeating characters is: " +
                lengthOfLongestSubstring(input));
    }
}
