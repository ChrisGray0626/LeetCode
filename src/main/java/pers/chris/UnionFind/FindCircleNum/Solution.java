package pers.chris.UnionFind.FindCircleNum;

import java.util.HashMap;
import java.util.Map;

class Solution {

    int[][] isConnected;
    int circle = 0;

    Map<Integer, Integer> map = new HashMap<>();
    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;

        init();

        for (int i = 0; i < isConnected.length; i ++){
            for (int j = i + 1; j < isConnected.length; j ++){
                if (isConnected[i][j] == 1){
                    merge(i, j);
                }
            }
        }

        return circle;
    }

    public void init(){
        for (int i = 0; i < isConnected.length; i ++){
            map.put(i, i);
            circle ++;
        }
    }

    public void add(int x){
        if (!map.containsKey(x)){
            map.put(x, x);
            circle ++;
        }
    }

    public int find(int x){
        int root = x;
        // Find Father
        while (map.get(root) != root){
            root = map.get(root);
        }

        // Path Compression
        while (x != root){
            map.put(x, root);
            x = map.get(x);
        }

        return root;
    }

    public void merge(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY){
            map.put(rootX, rootY);
            circle --;
        }
    }
}
