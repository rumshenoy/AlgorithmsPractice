package com.algorithmspractice.trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//           3
//          / \
//         9  20
//        /     \
//       15      7
//return its level order traversal as:
//[
//[3],
//[9,20],
//[15,7]
//]
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        System.out.println(levelOrder(root1));

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.left.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println(levelOrder(root2));

        System.out.println(levelOrder(null));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>(), parents;

        current.push(root);

        while(!current.isEmpty()){
            parents = current;
            current = new LinkedList<>();
            List<Integer> values = new ArrayList<>();
            for(TreeNode p: parents) {
                if(p != null){
                    current.add(p.left);
                    current.add(p.right);
                    values.add(p.val);
                }
            }
            if(!values.isEmpty()){
                result.add(values);
            }
        }
        return result;
    }
}
