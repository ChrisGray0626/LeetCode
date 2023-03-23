package pers.chris.Simulation.buddyStrings;

class Solution {
    public boolean buddyStrings(String s, String goal) {
        int m = s.length(), n = goal.length();
        if (m != n) {
            return false;
        }

        int[] cnt1 = new int[26], cnt2 = new int[26];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a', b = goal.charAt(i) - 'a';
            cnt1[a]++; cnt2[b]++;
            // 不同字符数量统计
            if (a != b) {
                sum++;
            }
        }
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            // 词频不同必然不为亲密字符
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
            // 词频相同，且同时出现数量超过2的字符，必然为亲密字符
            if (cnt1[i] > 1) {
                flag = true;
            }
        }
        return sum == 2 || (sum == 0 && flag);
    }
}
