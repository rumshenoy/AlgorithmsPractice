package com.algorithmspractice.trees;
//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//For example:
//Given the following binary tree,
//          1           <---
//        /   \
//       2     3         <---
//        \     \
//          5     4       <---
//You should return [1, 3, 4].

import java.util.*;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView rightSideView = new BinaryTreeRightSideView();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.right = new TreeNode(5);
        t1.right.right = new TreeNode(4);
        System.out.println(rightSideView.rightSideView(t1));

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.right = six;
        six.left = eight;

        four.right = seven;
        seven.right = nine;
        nine.right = ten;

        System.out.println(rightSideView.rightSideView(one));
    }

    public List<Integer> rightSideView(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        Stack<Integer> depthStack = new Stack();
        Map<Integer, Integer> rightMostValueAtLevel = new HashMap<>();
        stack.push(root);
        depthStack.push(0);

        int maxDepth = -1;

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int depth = depthStack.pop();
            maxDepth = Math.max(depth, maxDepth);

            if(node != null){
                if(!rightMostValueAtLevel.containsKey(depth)){
                    rightMostValueAtLevel.put(depth, node.val);
                }

                stack.push(node.left);
                stack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i =0; i < maxDepth; i++){
            result.add(rightMostValueAtLevel.get(i));
        }
        return result;
    }
}