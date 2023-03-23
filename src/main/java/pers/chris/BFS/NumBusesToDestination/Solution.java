package pers.chris.BFS.NumBusesToDestination;

import java.util.*;

public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int n = routes.length; // 公交线路数
        boolean[][] edges = new boolean[n][n]; // 路线之间的联通情况
        Map<Integer, List<Integer>> siteRoutes = new HashMap<>(); // 站台联通路线情况

        // 遍历i号路线途径的车站
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> routeList = siteRoutes.getOrDefault(site, new ArrayList<>());
                for (int route : routeList) {
                    edges[i][route] = edges[route][i] = true;
                }
                routeList.add(i);
                siteRoutes.put(site, routeList);
            }
        }

        int[] dis = new int[n]; // source至其他路线的最短距离
        Arrays.fill(dis, -1);
        Queue<Integer> queue = new LinkedList<>();
        // 遍历可到source的所有路线
        for (int route : siteRoutes.getOrDefault(source, new ArrayList<>())) {
            dis[route] = 1; // source到可达路线的距离为1
            queue.offer(route);
        }

        // BFS反复搜索相邻路线
        while (!queue.isEmpty()) {
            int route = queue.poll();
            for (int nextRoute = 0; nextRoute < n; nextRoute++) {
                if (edges[route][nextRoute] && dis[nextRoute] == -1){
                    dis[nextRoute] = dis[route] + 1;
                    queue.offer(nextRoute);
                }
            }
        }

        int minDis = Integer.MAX_VALUE;
        // 遍历可达target的所有路线
        for (int route : siteRoutes.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[route] != -1) {
                minDis = Math.min(minDis, dis[route]);
            }
        }
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
}
