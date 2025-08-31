package com.empiricism.traversal.binary;

class TraversalsRecursive {
    void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }

    int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TraversalsRecursive t = new TraversalsRecursive();

        System.out.print("Preorder: ");
        t.preorder(tree.root);
        System.out.println();

        System.out.print("Inorder: ");
        t.inorder(tree.root);
        System.out.println();

        System.out.print("Postorder: ");
        t.postorder(tree.root);
        System.out.println();

        System.out.println("Height of tree: " + t.height(tree.root));
    }
}

