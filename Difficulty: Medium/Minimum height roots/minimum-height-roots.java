import java.util.*;

class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        if (V == 1) {
            result.add(0);
            return result;
        }
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (graph.get(i).size() == 1) {
                leaves.offer(i);
            }
        }
        int remainingNodes = V;
        while (remainingNodes > 2) {
            int size = leaves.size();
            remainingNodes -= size;
            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                for (int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);
                    if (graph.get(neighbor).size() == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }
        result.addAll(leaves);
        return result;
    }
}