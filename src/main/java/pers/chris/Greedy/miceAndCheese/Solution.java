package pers.chris.Greedy.miceAndCheese;

import java.util.PriorityQueue;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/7
 */
class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < reward1.length; i++) {
            sum += reward2[i];
            queue.add(reward1[i] - reward2[i]);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        return sum;
    }
}