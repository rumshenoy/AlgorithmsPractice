package com.algorithmspractice.trees;
//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//According to the definition of LCA on Wikipedia:
//“The lowest common ancestor is defined between two nodes v and w as the lowest node in T that
//has both v and w as descendants (where we allow a node to be a descendant of itself).”
//
//            _______3______
//            /              \
//        ___5__          ___1__
//        /      \        /      \
//        6      _2       0       8
//        /  \
//        7   4
//For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
//Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(9);
        TreeNode one = new TreeNode(1);
        t1.left.left = one;
        TreeNode three = new TreeNode(3);
        t1.left.right = three;
        TreeNode six = new TreeNode(6);
        t1.right.left = six;
        t1.right.right = new TreeNode(10);

        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();
        System.out.println((lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(t1, one, six)).val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p|| root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null? right: right == null? left: root;
     }
}
