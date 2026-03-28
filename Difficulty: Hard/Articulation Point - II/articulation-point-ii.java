class Solution {
    static int timer;
    public static void dfs(int node, int parent, boolean[] vis,
                           int[] tin, int[] low,
                           ArrayList<ArrayList<Integer>> adj,
                           boolean[] isArticulation) {
        vis[node] = true;
        tin[node] = low[node] = timer++;
        int children = 0;
        for (int neigh : adj.get(node)) {
            if (neigh == parent) continue;
            if (!vis[neigh]) {
                dfs(neigh, node, vis, tin, low, adj, isArticulation);
                low[node] = Math.min(low[node], low[neigh]);
                if (parent != -1 && low[neigh] >= tin[node]) {
                    isArticulation[node] = true;
                }
                children++;
            } else {
                low[node] = Math.min(low[node], tin[neigh]);
            }
        }
        if (parent == -1 && children > 1) {
            isArticulation[node] = true;
        }
    }
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] isArticulation = new boolean[V];
        timer = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, tin, low, adj, isArticulation);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) result.add(i);
        }
        if (result.size() == 0) {
            result.add(-1);
        }
        return result;
    }
}