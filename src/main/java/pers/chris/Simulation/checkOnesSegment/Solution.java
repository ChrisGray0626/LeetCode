package pers.chris.Simulation.checkOnesSegment;

class Solution {

    private static final char CHAR_0 = '0';
    private static final char CHAR_1 = '1';

    public boolean checkOnesSegment(String s) {
        int len = s.length();
        int idx = 0;
        // 遍历直到出现 0，当前连续 1 字段结束
        while (idx < len) {
            if (s.charAt(idx) == CHAR_0) {
                break;
            }
            idx++;
        }
        // 若再出现字段 1，则不符合要求
        while (idx < len) {
            if (s.charAt(idx) == CHAR_1) {
                return false;
            }
            idx++;
        }
        return true;
    }
}
