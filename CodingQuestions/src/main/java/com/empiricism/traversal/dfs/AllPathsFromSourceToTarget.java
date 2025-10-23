package com.empiricism.traversal.dfs;
//https://leetcode.com/problems/all-paths-from-source-to-target/description/
import java.util.*;

public class AllPathsFromSourceToTarget {



        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> result = new ArrayList<>();
            if (graph == null || graph.length == 0) {
                return result;
            }
            int target = graph.length - 1;
            List<Integer> path = new ArrayList<>();
            path.add(0);  // start path from node 0

            dfs(graph, 0, target, path, result);
            return result;
        }

        /**
         * DFS helper that extends paths from current node to target.
         * @param graph adjacency representation
         * @param node current node
         * @param target the destination node (graph.length - 1)
         * @param path the current path from 0 to node
         * @param result collected paths from 0 to target
         */
        private void dfs(int[][] graph, int node, int target,
                         List<Integer> path, List<List<Integer>> result) {
            // If we've reached destination, record this path
            if (node == target) {
                // Important: add a *copy* of path, not `path` itself
                result.add(new ArrayList<>(path));
                return;
            }

            // Otherwise, explore neighbors
            for (int nei : graph[node]) {
                // Extend path
                path.add(nei);

                // Recur
                dfs(graph, nei, target, path, result);

                // Backtrack: remove the last added node before exploring next neighbor
                path.removeLast();
            }
        }


}
