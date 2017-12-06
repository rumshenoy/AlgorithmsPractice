package com.algorithmspractice.trees;
//https://leetcode.com/problems/merge-two-binary-trees/description/
public class MergeBinaryTree {

    public static void main(String args[]){
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(5);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(4);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(1);
        t2.right.left = new TreeNode(3);
        t2.right.right = new TreeNode(2);

        TreeNode t3 = mergeTwoBinaryTrees(t1, t2);
        preOrderTraversal(t3);

    }

    private static void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static TreeNode mergeTwoBinaryTrees(TreeNode t1, TreeNode t2) {
        TreeNode sum = null;
        if(t1 != null && t2 != null){
            sum = new TreeNode(t1.val + t2.val);
            sum.left = mergeTwoBinaryTrees(t1.left, t2.left);
            sum.right = mergeTwoBinaryTrees(t1.right, t2.right);
        }

        if(t1 == null){
            sum = t2;
        }

        if(t2 == null){
            sum = t1;
        }
        return sum;
    }
}
