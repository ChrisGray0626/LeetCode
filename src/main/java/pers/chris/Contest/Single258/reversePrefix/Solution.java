package pers.chris.Contest.Single258.reversePrefix;

class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = 0;
        int len = word.length();
        if (len == 0) {
            return word;
        }
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) == ch) {
                idx = i;
                flag = false;
                break;
            }
        }

        if (flag) {
            return word;
        }

        StringBuilder left = new StringBuilder(word.substring(0, idx + 1));
        String right = word.substring(idx + 1, len);
        return left.reverse().toString() + right;
    }
}
