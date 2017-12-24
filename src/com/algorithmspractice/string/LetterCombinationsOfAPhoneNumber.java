package com.algorithmspractice.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given a digit string, return all possible letter combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below.
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Although the above answer is in lexicographical order, your answer could be in any order you want.
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("45"));
    }
    public static List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> queue = new LinkedList<>();
        queue.add("");

        for(int i =0; i < digits.length(); i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(queue.peek().length() == i){
                String t = queue.remove();
                for(Character c: mapping[x].toCharArray()){
                    queue.add(t+c);
                }
            }
        }

        return queue;
    }
}
