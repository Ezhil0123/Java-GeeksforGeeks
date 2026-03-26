class Solution {
    public int countPaths(int V, int[][] edges) {
        int MOD = (int)1e9 + 7;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[V];
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});
        while(!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int)curr[1];
            if(d > dist[u]) continue;
            for(int[] nei : adj.get(u)) {
                int v = nei[0];
                int w = nei[1];
                long newDist = d + w;
                if(newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new long[]{newDist, v});
                }
                else if(newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[V - 1];
    }
}