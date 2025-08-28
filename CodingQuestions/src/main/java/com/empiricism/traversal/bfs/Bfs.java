package com.empiricism.traversal.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {
    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }

        return result;
    }
    public static void main(String[] args) {
        Bfs sol = new Bfs();

        // Test Case 1: Balanced Tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Test Case 1:");
        printLevelOrder(sol.levelOrder(root1));

        // Test Case 2: Single Node
        TreeNode root2 = new TreeNode(1);
        System.out.println("\nTest Case 2:");
        printLevelOrder(sol.levelOrder(root2));

        // Test Case 3: Empty Tree
        TreeNode root3 = null;
        System.out.println("\nTest Case 3:");
        printLevelOrder(sol.levelOrder(root3));

        // Test Case 4: Left Skewed Tree
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        root4.left.left.left = new TreeNode(4);
        System.out.println("\nTest Case 4:");
        printLevelOrder(sol.levelOrder(root4));

        // Test Case 5: Right Skewed Tree
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        root5.right.right = new TreeNode(3);
        root5.right.right.right = new TreeNode(4);
        System.out.println("\nTest Case 5:");
        printLevelOrder(sol.levelOrder(root5));
    }
    // Helper method to print results
    private static void printLevelOrder(List<List<Integer>> result) {
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

}
