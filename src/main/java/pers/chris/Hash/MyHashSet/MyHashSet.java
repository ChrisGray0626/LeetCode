package pers.chris.Hash.MyHashSet;

import java.util.Iterator;
import java.util.LinkedList;

class MyHashSet {

    private LinkedList[] data;
    private static final int MOD = 769;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new LinkedList[MOD];
        for (int i = 0; i <data.length; i ++){
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);

        for (Integer ele : (Iterable<Integer>) data[h]) {
            if (ele == key) {
                return;
            }
        }

        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (iterator.next() == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);

        for (Integer ele : (Iterable<Integer>) data[h]) {
            if (ele.equals(key)) {
                return true;
            }
        }

        return false;
    }

    private static int hash(int key){
        return key % MOD;
    }
}
