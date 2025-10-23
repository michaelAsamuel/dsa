package com.empiricism.traversal.bfs;

import java.util.*;

public class BFSTemplate {

    // BFS function for a graph represented as adjacency list
    public void bfs(int start, List<List<Integer>> graph) {
        int n = graph.size(); // number of nodes
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " "); // process the node

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example graph with 5 nodes (0 to 4)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(2).add(3);
        graph.get(3).add(3);
        graph.get(1).add(4);

        BFSTemplate bfs = new BFSTemplate();
        System.out.println("BFS starting from node 2:");
        bfs.bfs(2, graph);
    }
}

