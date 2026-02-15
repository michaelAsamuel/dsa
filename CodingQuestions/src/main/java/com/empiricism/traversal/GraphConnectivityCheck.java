package com.empiricism.traversal;

import java.util.LinkedList;

public class GraphConnectivityCheck {

    static class Graph {
        int vertices;
        // Array of LinkedLists to represent the Adjacency List
        LinkedList<Integer> adjacencyList[];

        @SuppressWarnings("unchecked")
        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        // Function to add an undirected edge
        public void addEdge(int source, int dest) {
            adjacencyList[source].add(dest);
            adjacencyList[dest].add(source); // For undirected graph
        }
    }

    // DFS utility function
    public static void DFS(int source, LinkedList<Integer>[] adjList, boolean[] visited) {
        visited[source] = true;

        for (int neighbor : adjList[source]) {
            if (!visited[neighbor]) {
                DFS(neighbor, adjList, visited);
            }
        }
    }

    // Main function to check connectivity
    public static boolean isConnected(Graph graph) {
        int V = graph.vertices;
        if (V == 0) return true; // An empty graph is trivially connected

        boolean[] visited = new boolean[V];

        // 1. Start DFS from an arbitrary vertex (Node 0)
        DFS(0, graph.adjacencyList, visited);

        // 2. Check if all vertices are visited
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // If any node is unvisited, it belongs to a different component
                return false; // Graph is disconnected
            }
        }

        // 3. If all nodes were reached, the graph is connected
        return true;
    }

    public static void main(String[] args) {
        // --- Test Case 1: Connected Graph ---
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Graph 1 is connected: " + isConnected(g1)); // Output: true

        // --- Test Case 2: Disconnected Graph ---
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(2, 3);
        // Node 4 is isolated, and the component (0,1) is separate from (2,3)
        System.out.println("Graph 2 is connected: " + isConnected(g2)); // Output: false
    }
}