package com.empiricism.traversal.binary;

import java.util.*;

public class LowestCommonAncestor {
    TreeNode findLCA(TreeNode root, int p, int q) {
        // Base case: reached the end or found one of the targets
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;

        // Recurse on left and right subtrees
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        // Otherwise, return whichever non-null side
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: reached the end or found one of the targets
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recurse on left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return non-null, p and q are in different subtrees
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return whichever non-null side
        return (left != null) ? left : right;

    }

    public TreeNode lowestCommonAncestorIT(TreeNode root, TreeNode p, TreeNode q) {
        // Map to store parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        parent.put(root, null);
        queue.offer(root);

        // Step 1: BFS until both p and q are found
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                parent.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }

        // Step 2: Collect ancestors of p
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // Step 3: Walk up from q until hitting common ancestor
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

    public static void main(String[] args) {
        // Build sample tree
        /*
                 3
                / \
               5   1
              / \ / \
             6  2 0  8
               / \
              7   4
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestor sol = new LowestCommonAncestor();

        // Testcases
        TreeNode lca1 = sol.lowestCommonAncestor(root, root.left, root.right); // LCA of 5 and 1
        System.out.println("LCA of 5 and 1 = " + lca1.val); // Expected 3

        TreeNode lca2 = sol.lowestCommonAncestor(root, root.left, root.left.right.right); // LCA of 5 and 4
        System.out.println("LCA of 5 and 4 = " + lca2.val); // Expected 5

        TreeNode lca3 = sol.lowestCommonAncestor(root, root.left.right.left, root.left.right.right); // LCA of 7 and 4
        System.out.println("LCA of 7 and 4 = " + lca3.val); // Expected 2

        TreeNode lca4 = sol.lowestCommonAncestor(root, root.left.left, root.left.right.left); // LCA of 6 and 7
        System.out.println("LCA of 6 and 7 = " + lca4.val); // Expected 5
    }
}
