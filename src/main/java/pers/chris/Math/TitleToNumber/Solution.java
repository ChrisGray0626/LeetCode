package pers.chris.Math.TitleToNumber;

class Solution {
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int res = 0;
        int bit = len - 1;

        for (int i = 0; i < len; i ++) {
            char ch = columnTitle.charAt(i);
            int num = ch - 'A' + 1;
            res += num * Math.pow(26, bit);
            bit --;
        }
        return res;
    }
}
