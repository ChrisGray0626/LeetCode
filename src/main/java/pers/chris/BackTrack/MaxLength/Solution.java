package pers.chris.BackTrack.MaxLength;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> masks = new ArrayList<>();
    int res = 0;

    public int maxLength(List<String> arr) {
        for (String s: arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i ++) {
                int ch = s.charAt(i) - 'a';
                // mask右移至当前字符位置判断是否为1
                if (((mask >> ch) & 1) != 0) {
                    mask = 0;
                    break;
                }
                // mask当前字符位置置1
                mask |= 1 << ch;

            }
            if (mask > 0) {
                masks.add(mask);
            }
        }
        backTrack(0 ,0);

        return res;
    }

    public void backTrack(int pos, int mask) {
        if (pos == masks.size()) {
            // 字符串长度即为1的位数
            res = Math.max(res, Integer.bitCount(mask));
            return;
        }

        // 判断字符是否重复
        if ((mask & masks.get(pos)) == 0) {
            // 选择当前字符串
            backTrack(pos + 1, mask | masks.get(pos));
        }

        // 不选择当前字符串
        backTrack(pos + 1, mask);
    }
}
