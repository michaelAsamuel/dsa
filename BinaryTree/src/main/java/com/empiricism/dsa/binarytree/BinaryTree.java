package com.empiricism.dsa.binarytree;

// Definition of Binary Tree Node
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // In-order traversal of binary tree
    void inOrder(Node node) {
        if (node == null)
            return;

        // Traverse the left subtree
        inOrder(node.left);

        // Visit the root node
        System.out.print(node.data + " ");

        // Traverse the right subtree
        inOrder(node.right);
    }

    // Pre-order traversal of binary tree
    void preOrder(Node node) {
        if (node == null)
            return;

        // Visit the root node
        System.out.print(node.data + " ");

        // Traverse the left subtree
        preOrder(node.left);

        // Traverse the right subtree
        preOrder(node.right);
    }

    // Post Order Traversal
    void postOrder(Node node) {
        if (node == null)
            return;

        // Traverse the left subtree
        postOrder(node.left);

        // Traverse the right subtree
        postOrder(node.right);

        // Visit the root node
        System.out.print(node.data + " ");
    }




    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        // In-order traversal
        System.out.println("In-order traversal: ");
        tree.inOrder(tree.root);

        // Pre-order traversal
//        System.out.println("Pre-order traversal: ");
//        tree.preOrder(tree.root);
    }


}

