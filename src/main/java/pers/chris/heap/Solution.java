package pers.chris.heap;

import java.util.Collection;
import java.util.PriorityQueue;

public class Solution {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            queue.offer(arr[i]);
            queue.poll();
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}