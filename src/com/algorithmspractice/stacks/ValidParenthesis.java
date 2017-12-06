package com.algorithmspractice.stacks;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String args[]){
        System.out.println(isValid("([])"));
        System.out.println(isValid("([])()"));
        System.out.println(isValid("([]{}()}"));
    }
    public static boolean isValid(String s) {
        Stack stack = new Stack();
        stack.push(s.charAt(0));
        for(int i=1; i< s.length(); i++){
            if(!stack.empty()) {
                if ((char) stack.peek() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else if ((char) stack.peek() == '{' && s.charAt(i) == '}') {
                    stack.pop();
                } else if ((char) stack.peek() == '[' && s.charAt(i) == ']') {
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }

        if(stack.empty()){
            return true;
        }
        else{
            return false;
        }

    }
}
