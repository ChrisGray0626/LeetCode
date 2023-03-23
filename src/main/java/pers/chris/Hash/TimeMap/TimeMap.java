package pers.chris.Hash.TimeMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    private Map<String, Map<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Map<Integer, String> valueMap = map.getOrDefault(key, new TreeMap<>(Comparator.reverseOrder()));
        valueMap.put(timestamp, value);
        map.put(key, valueMap);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        Map<Integer, String> valueMap = map.get(key);
        for (Map.Entry<Integer, String> entry: valueMap.entrySet()) {
            if (timestamp >= entry.getKey()) {
                return entry.getValue();
            }
        }
        return "";
    }
}
