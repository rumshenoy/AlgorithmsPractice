package com.algorithmspractice.trees;

public class TreeTraversal {
    public static void main(String[] args){
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(5);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(4);

        inOrderTraversal(t1);
        System.out.println();
        preOrderTraversal(t1);
        System.out.println();
        postOrderTraversal(t1);
    }

    public static void visit(TreeNode node){
        System.out.print(node.val + " ");
    }

    public static void inOrderTraversal(TreeNode node){
        if(node != null){
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
   }

    public static void preOrderTraversal(TreeNode node){
        if(node != null){
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(TreeNode node){
        if(node != null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }
}
