package com.algorithmspractice.trees;

import java.util.Stack;

//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//Example 1:
//            2
//           / \
//          1   3
//Binary tree [2,1,3], return true.
//Example 2:
//            1
//           / \
//          2   3
//Binary tree [1,2,3], return false.
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(5);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(4);
        System.out.println(isValidBST(t1));

        TreeNode t2 = new TreeNode(8);
        t2.left = new TreeNode(5);
        t2.left.left = new TreeNode(2);
        t2.left.right = new TreeNode(6);
        System.out.println(isValidBST(t2));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        TreeNode pre = null, cur = root;
        Stack<TreeNode> stack = new Stack();

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if(pre != null && pre.val >= cur.val){
                return false;
            }

            pre = cur;
            if(cur!= null){
                cur = cur.right;
            }

        }
        return true;
    }
}
