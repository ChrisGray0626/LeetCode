package pers.chris.Contest.Single256.minSessions;

import java.util.Arrays;

class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int len = tasks.length;
        // 所有状态的数量
        int stateSum = 1 << len;
        final int INF = 20;
        int[] dp = new int[stateSum];

        Arrays.fill(dp, INF);

        // 预处理每个状态，合法状态预设为 1
        for (int i = 1; i < stateSum; i++) {
            int state = i, idx = 0;
            // 当前状态子集的总花费时间
            int spend = 0;

            while (state > 0) {
                // 取当前状态的末位
                int bit = state & 1;
                // 选择第i个的任务
                if (bit == 1) {
                    spend += tasks[idx];
                }
                // 状态右移至下一个任务
                state >>= 1;
                idx++;
            }

            // 当前状态子集能在一个工作时间段完成，状态合法
            if (spend <= sessionTime) {
                dp[i] = 1;
            }
        }

        // 枚举状态子集
        for (int i = 1; i < stateSum; i++) {
            // 跳过已经有最优解的状态
            if (dp[i] != INF) {
                continue;
            }
            // 枚举状态 i 的所有子集
            for (int j = i; j > 0; j = (j - 1) & i) {
                // 状态 i 的最优解可由当前子集 j 与子集 j 的补集得来
                dp[i] = Math.min(dp[i], dp[j] + dp[i ^ j]);
            }
        }

        return dp[stateSum - 1];
    }
}