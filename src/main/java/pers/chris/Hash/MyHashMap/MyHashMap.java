package pers.chris.Hash.MyHashMap;

import java.util.ArrayList;
import java.util.List;

class MyHashMap {

    private int[] map;
    private List<Boolean> flags;
    final static int MAX = 1000000;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[MAX];
        flags = new ArrayList<>();
        for (int i = 0; i < MAX; i ++){
            flags.add(i, false);
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
        flags.set(key, true);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (flags.get(key)){
            return map[key];
        }
        else {
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        flags.set(key, false);
    }
}
