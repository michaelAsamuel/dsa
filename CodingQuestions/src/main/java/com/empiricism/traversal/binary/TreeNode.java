package com.empiricism.traversal.binary;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

// Sample Tree:
//        1
//       / \
//      2   3
//     / \   \
//    4   5   6
class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
    }
}

