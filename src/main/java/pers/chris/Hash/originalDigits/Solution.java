package pers.chris.Hash.originalDigits;

class Solution {
    public String originalDigits(String s) {
        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        int[] digits = new int[10];
        // Z
        digits[0] = cnt[25];
        cnt[14] -= cnt[25];
        // W
        digits[2] = cnt[22];
        cnt[14] -= cnt[22];
        // U
        digits[4] = cnt[20];
        cnt[5] -= cnt[20];
        cnt[14] -= cnt[20];
        // X
        digits[6] = cnt[23];
        cnt[18] -= cnt[23];
        cnt[8] -= cnt[23];
        // G
        digits[8] = cnt[6];
        cnt[7] -= cnt[6];
        cnt[8] -= cnt[6];
        // H
        digits[3] = cnt[7];
        // F
        digits[5] = cnt[5];
        cnt[8] -= cnt[5];
        // S
        digits[7] = cnt[18];
        // O
        digits[1] = cnt[14];
        // I
        digits[9] = cnt[8];

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < 10; i++) {
//            res.append(String.valueOf(i).repeat(Math.max(0, digits[i])));
        }
        return res.toString();
    }
}
