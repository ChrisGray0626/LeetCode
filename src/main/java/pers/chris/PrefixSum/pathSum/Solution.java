package pers.chris.PrefixSum.pathSum;

import pers.chris.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private int sum;
    private Map<Integer, Integer> prefix;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        sum = 0;
        prefix = new HashMap<>();

        // 空路径预处理
        prefix.put(0, 1);

        dfs(root, 0, targetSum);
        return sum;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        int val = root.val;
        if (val == targetSum) {
            sum++;
        }

        // 统计左右节点
        dfs(root.left, targetSum - val);
        dfs(root.right, targetSum - val);
    }

    public void dfs(TreeNode root, int cur, int targetSum) {
        if (root == null) {
            return;
        }

        // 计算前缀和
        cur += root.val;

        // 统计符合的前缀和
        sum += prefix.getOrDefault(cur - targetSum, 0);

        // 记录当前节点的前缀和
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        dfs(root.left, cur, targetSum);
        dfs(root.right, cur, targetSum);
        // 回溯时移除当前节点前缀和
        prefix.put(cur, prefix.getOrDefault(cur, 0) - 1);
    }
}
