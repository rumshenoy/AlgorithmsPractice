package com.algorithmspractice.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given a binary tree, return the inorder traversal of its nodes' values.
//
//        For example:
//        Given binary tree [1,null,2,3],
//        1
//        \
//          2
//        /
//        3
//        return [1,3,2].
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        System.out.println(inorderTraversal(root1));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> s = new Stack();
        TreeNode cur = root;
        s.add(root);
        while(!s.isEmpty()){
            if(cur != null){
                s.add(cur.left);
                cur = cur.left;
            }else {
                cur = s.pop();
                if (cur != null) {
                    traversal.add(cur.val);
                    s.add(cur.right);
                    cur = cur.right;
                }
            }
        }
        return traversal;
    }

}
