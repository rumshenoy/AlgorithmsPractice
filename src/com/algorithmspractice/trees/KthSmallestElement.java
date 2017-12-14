package com.algorithmspractice.trees;

import java.util.Stack;

//find the kth smallest element in a BST
public class KthSmallestElement {
    public static void main(String args[]){
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(9);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(3);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(10);
        System.out.println(kthSmallest(t1, 6));
    }

    private static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;
        while(!stack.isEmpty() || p != null){
            if(p!= null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                count++;
                if(count == k){
                    return p.val;
                }
                p = p.right;

            }
        }
        return Integer.MAX_VALUE;
    }
}
