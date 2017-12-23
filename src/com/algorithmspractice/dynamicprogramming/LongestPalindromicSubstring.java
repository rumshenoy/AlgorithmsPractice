package com.algorithmspractice.dynamicprogramming;

public class LongestPalindromicSubstring {
//    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//    Example:
//    Input: "babad"
//    Output: "bab"
//    Note: "aba" is also a valid answer.
//    Example:
//    Input: "cbbd"
//    Output: "bb"

    public static void main(String args[]){
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("abbababababd"));
    }

    public static String longestPalindrome(String s) {
        int max =0;
        int longestStart = 0;
        boolean[][] table = new boolean[1000][1000];
        for(int i =0; i < s.length(); i++) {
                table[i][i] = true;
                max = 1;
        }

        for(int i =0; i < s.length() -1; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                table[i][i+1] = true;
                longestStart = i;
                max = 2;
            }
        }

        for(int len = 3; len < s.length(); len++){
            for(int i = 0; i < s.length() - len + 1 ; i++){
                int j = i + len -1;
                if(s.charAt(i) == s.charAt(j) && table[i+1][j-1]) {
                    table[i][j] = true;
                    if(len > max){
                        max = len;
                        longestStart = i;
                    }
                }
            }
        }

        return s.substring(longestStart, longestStart +max);
    }

}
