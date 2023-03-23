package pers.chris.DynamicProgramming.DivisorGame;

class Solution {
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 2];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i ++){
            for (int j = 1; j < i; j ++){
                if (i % j == 0 && !dp[i - j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[N];
    }
}
