package pers.chris.BitOperation.ReadBinaryWatch;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn > 9) {
            return null;
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < 1024; i ++) {
            int hour = i >> 6;
            int min = i & 63;

            if (Integer.bitCount(i) == turnedOn && hour < 12 && min < 60) {
                res.add(hour + ":" + (min < 10 ? "0" : "") + min);
            }
        }
        return res;
    }
}
