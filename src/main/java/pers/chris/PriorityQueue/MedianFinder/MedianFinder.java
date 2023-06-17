package pers.chris.PriorityQueue.MedianFinder;

import java.util.PriorityQueue;

public class MedianFinder {

    private final PriorityQueue<Integer> minQueue;
    private final PriorityQueue<Integer> maxQueue;

    public MedianFinder() {
        minQueue = new PriorityQueue<>((a, b) -> (b - a));
        maxQueue = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (minQueue.isEmpty() || num <= minQueue.peek()) {
            minQueue.offer(num);
            if (minQueue.size() > maxQueue.size() + 1) {
                maxQueue.offer(minQueue.poll());
            }
        } else {
            maxQueue.offer(num);
            if (maxQueue.size() > minQueue.size()) {
                minQueue.offer(maxQueue.poll());
            }
        }
    }

    public double findMedian() {
        if (minQueue.size() > maxQueue.size()) {
            return minQueue.element();
        }
        return (minQueue.element() + maxQueue.element()) / 2.0;
    }
}
