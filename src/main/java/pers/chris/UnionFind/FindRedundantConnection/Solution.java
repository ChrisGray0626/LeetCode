package pers.chris.UnionFind.FindRedundantConnection;

class Solution {

    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        parent = new int[len + 1];

        for (int i = 1; i <= len; i ++){
            parent[i] = i;
        }

        for (int[] edge: edges){
            int idx1 = edge[0];
            int idx2 = edge[1];

            if (find(idx1) != find(idx2)){
                merge(idx1, idx2);
            }
            else {
                return edge;
            }
        }

        return new int[0];
    }

    public int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void merge(int x, int y){
        parent[find(x)] = parent[find(y)];
    }
}
