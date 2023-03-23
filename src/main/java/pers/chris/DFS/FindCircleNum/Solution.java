package pers.chris.DFS.FindCircleNum;

class Solution {

    int sum;
    boolean[] visit;
    int[][] isConnected;

    public int findCircleNum(int[][] isConnected) {
        this.sum = isConnected.length;
        this.visit = new boolean[sum];
        this.isConnected = isConnected;

        int res = 0;
        for (int i = 0; i < sum; i ++){
            if (!visit[i]){
                dfs(i);
                res ++;
            }
        }
        return res;
    }

    public void dfs(int num){
        for (int i = 0; i < sum; i ++){
            if (!visit[i] && isConnected[num][i] == 1){
                visit[i] = true;
                dfs(i);
            }
        }
    }
}
