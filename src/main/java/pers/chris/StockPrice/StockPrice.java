package pers.chris.StockPrice;

import pers.chris.BFS.kSimilarity.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/8
 */
class StockPrice {

    private final Map<Integer, Integer> priceMap;
    private final PriorityQueue<Pair<Integer, Integer>> maxPriceHeap;
    private final PriorityQueue<Pair<Integer, Integer>> minPriceHeap;
    private int currentTimestamp;

    public StockPrice() {
        priceMap = new HashMap<>();
        maxPriceHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        minPriceHeap = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        currentTimestamp = 0;
    }

    public void update(int timestamp, int price) {
        priceMap.put(timestamp, price);
        maxPriceHeap.add(new Pair<>(timestamp, price));
        minPriceHeap.add(new Pair<>(timestamp, price));
        currentTimestamp = Math.max(currentTimestamp, timestamp);
    }

    public int current() {
        return priceMap.get(currentTimestamp);
    }

    public int maximum() {
        while (true) {
            Pair<Integer, Integer> pair = maxPriceHeap.peek();
            int timestamp = pair.getKey();
            int price = pair.getValue();
            if (price == priceMap.get(timestamp)) {
                return price;
            } else {
                maxPriceHeap.poll();
            }
        }
    }

    public int minimum() {
        while (true) {
            Pair<Integer, Integer> pair = minPriceHeap.peek();
            int timestamp = pair.getKey();
            int price = pair.getValue();
            if (price == priceMap.get(timestamp)) {
                return price;
            } else {
                minPriceHeap.poll();
            }
        }
    }
}