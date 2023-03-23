package pers.chris.DynamicProgramming;

public class Knapsack01 {

    public int solution(int w[], int v[], int W){
        int dp[][] = new int[w.length + 1][W + 1];
        for (int i = 1; i <= w.length; i ++){
            for (int j = W; j >= w[i]; j --){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
            }
        }
        return dp[w.length][W];
    }
}
