package pers.chris.UnionFind.EquationsPossible;

class Solution {

    int[] parent = new int[26];

    public boolean equationsPossible(String[] equations) {
        init(26);

        for (String equation: equations){
            if (equation.charAt(1) == '='){
                int idx1 = equation.charAt(0) - 'a';
                int idx2 = equation.charAt(3) - 'a';
                merge(idx1, idx2);
            }
        }

        for (String equation: equations){
            if (equation.charAt(1) == '!'){
                int idx1 = equation.charAt(0) - 'a';
                int idx2 = equation.charAt(3) - 'a';
                if (isConnected(idx1, idx2)){
                    return false;
                }
            }
        }
        return true;
    }

    public void init(int len){
        for (int i = 0; i < len; i ++){
            parent[i] = i;
        }
    }

    public int find(int x){
        int root = x;
        while (parent[root] != root){
            root = parent[root];
        }

        while (x != root){
            int tmp = parent[x];
            parent[x] = root;
            x = tmp;
        }

        return root;
    }

    public void merge(int x, int y){
        int findX = find(x);
        int findY = find(y);

        if (findX != findY){
            parent[findX] = findY;
        }
    }

    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}
