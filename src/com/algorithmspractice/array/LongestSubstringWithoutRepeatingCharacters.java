package com.algorithmspractice.array;

//Given a string, find the length of the longest substring without repeating characters.
//Examples:
//Given "abcabcbb", the answer is "abc", which the length is 3.
//Given "bbbbb", the answer is "b", with the length of 1.
//Given "pwwkew", the answer is "wke", with the length of 3.
// Note that the answer must be a substring, "pwke" is a sub sequence and not a substring.

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

    public static int lengthOfLongestSubstring(String s){
        Set<Character> seen = new HashSet<>();
        int i =0, j = 0, max = 0, n = s.length();
        while( i < n && j < n){
            if(!seen.contains(s.charAt(j))){
                seen.add(s.charAt(j++));
                max = Math.max(max, j-i);
            }else{
                seen.remove(s.charAt(i++));

            }
        }

        return max;
    }
}
