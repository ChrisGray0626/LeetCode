package pers.chris.Dijkstra.NetworkDelayTime;

import java.util.Arrays;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] edges = new int[n][n];
        int[] dist = new int[n];
        Boolean[] visited = new Boolean[n];

        for (int i = 0; i < n; i ++) {
            Arrays.fill(edges[i], INF);
        }

        for (int[] t: times) {
            int src = t[0] - 1;
            int dst = t[1] - 1;
            edges[src][dst] = t[2];
//            edges[dst][src] = t[2];
        }

//        for (int i = 0; i < n; i ++) {
//            dist[i] = edges[i][k];
//        }
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i ++) {
            int idx = -1;
            for (int j = 0; j < n; j ++) {
                if (!visited[j] && (idx == -1 || dist[j] < dist[idx])) {
                    idx = j;
                }
            }
            visited[idx] = true;

            for (int j = 0; j < n; j ++) {
                dist[j] = Math.min(dist[j], dist[idx] + edges[idx][j]);
            }
        }

        int res = Arrays.stream(dist).max().getAsInt();
        return res == INF ? -1 : res;
    }
}
