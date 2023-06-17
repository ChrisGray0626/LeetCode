package pers.chris.PriorityQueue.getLeastNumbers;

import java.util.PriorityQueue;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/17
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> (b - a));

        for (int num: arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num < queue.element()) {
                queue.poll();
                queue.offer(num);
            }
        }

        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}