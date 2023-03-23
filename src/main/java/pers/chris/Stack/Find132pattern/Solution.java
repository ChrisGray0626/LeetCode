package pers.chris.Stack.Find132pattern;

import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] mins = new int[n];

        mins[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }

        // 从后往前遍历，stack 中的数字表示的是从位置 i 到 n 中，大于 mins[i] 且小于 nums[i] 的数
        for (int i = n - 1; i >= 0; i --) {
            if (nums[i] > mins[i]) {
                // 如果栈中的数字比 mins[i] 还小或者相同，那么说明不可能是 ak，就弹出来
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                // 检查一下栈顶元素是不是满足 ai<stack.peek()<aj，如果满足就说明找到了
                if (!stack.isEmpty() && stack.peek() > mins[i]) {
                    return true;
                }
                // 不管怎样都要push进来当前的数，因为当前的数满足了大于 mins[i]
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
