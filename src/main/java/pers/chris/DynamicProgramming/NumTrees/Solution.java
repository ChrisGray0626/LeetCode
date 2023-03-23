package pers.chris.DynamicProgramming.NumTrees;

public class Solution {

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;

        for (int k = 2; k <=n; k ++) {
            for (int i = 1; i <= k; i ++) {
                G[k] += G[i - 1] * G[k - i];
            }
        }
        return G[n];
    }
}
