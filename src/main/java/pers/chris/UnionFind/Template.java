package pers.chris.UnionFind;

import java.util.HashMap;
import java.util.Map;

class Template {
    private Map<Integer,Integer> father;

    public Template() {
        father = new HashMap<Integer,Integer>();
    }

    public void init(int len){
        for (int i = 0; i < len; i ++){
            father.put(i, i);
        }
    }

    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY){
            father.put(rootX,rootY);
        }
    }

    public int find(int x) {
        int root = x;

        // Find Father
        while(father.get(root) != root){
            root = father.get(root);
        }

        // Path Compression
        while(x != root){
            int tmp = father.get(x);
            father.put(x,root);
            x = tmp;
        }

        return root;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

