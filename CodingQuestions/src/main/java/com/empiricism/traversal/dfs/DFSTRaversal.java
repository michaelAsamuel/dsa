package com.empiricism.traversal.dfs;

import java.util.*;

public class DFSTRaversal {

    // Function to perform DFS
    public static void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        // Mark the node as visited
        visited[node] = true;

        // Print the node (you can do other processing here)
        System.out.print(node + " ");

        // Visit all neighbors of the current node
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);  // Recursive call
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;  // Number of nodes

        // Create an empty adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (undirected graph)
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(2);
        graph.get(2).add(0);

        graph.get(1).add(3);
        graph.get(3).add(1);

        graph.get(1).add(4);
        graph.get(4).add(1);

        // Visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];

        System.out.println("DFS starting from node 0:");
        dfs(0, visited, graph);
    }
}
