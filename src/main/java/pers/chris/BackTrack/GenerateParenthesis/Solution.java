package pers.chris.BackTrack.GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res;
    int len;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        len = n * 2;

        backTrack(new StringBuilder(), n, 0);

        return res;
    }
    public void backTrack(StringBuilder s, int lSum, int rSum) {
        if (s.length() == len) {
            res.add(s.toString());
            return;
        }

        if (lSum > 0) {
            s.append('(');
            backTrack(s, lSum - 1, rSum + 1);
            s.deleteCharAt(s.length() - 1);
        }
        if (rSum > 0) {
            s.append(')');
            backTrack(s, lSum, rSum - 1);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
