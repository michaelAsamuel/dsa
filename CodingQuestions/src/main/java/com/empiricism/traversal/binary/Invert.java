package com.empiricism.traversal.binary;

public class Invert {
    TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invert(root.right);
        root.right = invert(temp);
        return root;
    }
}
