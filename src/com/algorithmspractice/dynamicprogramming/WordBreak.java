package com.algorithmspractice.dynamicprogramming;
import java.util.*;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
// determine if s can be segmented into a space-separated sequence of one or more dictionary words.
// You may assume the dictionary does not contain duplicate words.
//
//For example, given
//s = "leetcode",
//dict = ["leet", "code"].
//
//Return true because "leetcode" can be segmented as "leet code".

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddogs", Arrays.asList(new String[]{"cats", "and", "dogs"})));
        System.out.println(wordBreak("catanddogs", Arrays.asList(new String[]{"cats", "and", "dogs"})));
        System.out.println(wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
        System.out.println(wordBreak("catsanddogs", Arrays.asList(new String[]{"catsanddogs", "cats", "and"})));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set dict = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <=s.length(); i++){
            for(int j =0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }


        return dp[s.length()];
    }
}
