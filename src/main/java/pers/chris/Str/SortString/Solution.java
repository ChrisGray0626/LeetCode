package pers.chris.Str.SortString;

class Solution {
    public String sortString(String s) {
        int[] num = new int[26];

        for (int i = 0; i < s.length(); i ++){
            num[s.charAt(i) - 'a'] ++;
        }

        StringBuffer res = new StringBuffer();

        while (res.length() < s.length()) {
            for (int i = 0; i < num.length; i++) {
                if (num[i] == 0) {
                    continue;
                }

                res.append((char) (i + 'a'));
                num[i]--;
            }

            for (int i = num.length - 1; i >= 0; i--) {
                if (num[i] == 0) {
                    continue;
                }

                res.append((char) (i + 'a'));
                num[i]--;
            }
        }
        return res.toString();
    }
}
