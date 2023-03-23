package pers.chris.Str.ModifyString;

import java.util.Arrays;

class Solution {
    public String modifyString(String s) {
        char[] ss = s.toCharArray();

        for (int i = 0; i < ss.length; i ++){
            if (ss[i] == '?') {
                char pre = i == 0 ? ' ' : ss[i - 1];
                char next = i == ss.length - 1 ? ' ' : ss[i + 1];
                char ch = 'a';
                while (ch == pre || ch == next) {
                    ch ++;
                }
                ss[i] = ch;
            }
        }
        return new String(ss);
    }
}
