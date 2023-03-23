package pers.chris.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class SummaryRanges {

    private final TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int val) {
        // 找到l1最小且满足l1>val的区间
        Map.Entry<Integer, Integer> interval1 = intervals.ceilingEntry(val + 1);
        // 找到l0最大且满足l0<=val的区间
        Map.Entry<Integer, Integer> interval0 = intervals.floorEntry(val);

        // 情况一
        if (interval0 != null && interval0.getKey() <= val && val <= interval0.getValue()) {
            return;
        }
        else {
            boolean leftAside = interval0 != null && interval0.getValue() + 1 == val;
            boolean rightAside = interval1 != null && interval1.getKey() - 1 == val;
            // 情况四
            if (leftAside && rightAside) {
                int left = interval0.getKey(), right = interval1.getValue();
                intervals.remove(interval0.getKey());
                intervals.remove(interval1.getKey());
                intervals.put(left, right);
            }
            // 情况二
            else if (leftAside) {
                intervals.put(interval0.getKey(), val);
            }
            // 情况三
            else if (rightAside) {
                intervals.put(val, interval1.getValue());
                intervals.remove(interval1.getKey());
            } else {
                // 情况五
                intervals.put(val, val);
            }
        }
    }

    public int[][] getIntervals() {
        int size = intervals.size();
        int[][] res = new int[size][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            int left = entry.getKey(), right = entry.getValue();
            res[index][0] = left;
            res[index][1] = right;
            index++;
        }
        return res;
    }

}
