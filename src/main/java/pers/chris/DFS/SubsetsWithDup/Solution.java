package pers.chris.DFS.SubsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return res;
    }

    public void dfs(boolean choosePre, int idx, int[] nums) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        dfs(true, idx + 1, nums);
        list.remove(list.size() - 1);

        if (choosePre && nums[idx - 1] == nums[idx]){
            return;
        }
        dfs(false, idx + 1, nums);
    }
}
