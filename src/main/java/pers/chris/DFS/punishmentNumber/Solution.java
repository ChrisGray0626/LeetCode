package pers.chris.DFS.punishmentNumber;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/25
 */
class Solution {

    public int punishmentNumber(int n) {
        int res = 0;

        for (int i = 1; i < n + 1; i++) {
            if (dfs(i * i, i)) {
                res += i * i;
            }
        }
        return res;
    }

    private boolean dfs(int source, int target) {
        if (source == target) {
            return true;
        }
        if (source < target) {
            return false;
        }
        for (int base = 10; base <= source; base *= 10) {
            if (dfs(source / base, target - source % base)) {
                return true;
            }
        }
        return false;
    }
}
