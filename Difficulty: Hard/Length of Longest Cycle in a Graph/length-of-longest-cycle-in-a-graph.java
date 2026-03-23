class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] next = new int[V];
        for (int i = 0; i < V; i++) next[i] = -1;
        for (int[] e : edges) {
            next[e[0]] = e[1];
        }
        int[] visited = new int[V];
        int[] timeVisited = new int[V];
        int time = 1;
        int maxCycle = -1;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                int node = i;
                int startTime = time;
                while (node != -1 && visited[node] == 0) {
                    visited[node] = 1;
                    timeVisited[node] = time++;
                    node = next[node];
                }
                if (node != -1 && timeVisited[node] >= startTime) {
                    int cycleLength = time - timeVisited[node];
                    maxCycle = Math.max(maxCycle, cycleLength);
                }
            }
        }
        return maxCycle;
    }
}