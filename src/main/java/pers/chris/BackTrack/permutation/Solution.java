package pers.chris.BackTrack.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/13
 */
class Solution {

    private final List<String> res = new ArrayList<>();
    private char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        search(0);

        return res.toArray(new String[0]);
    }

    private void search(int index) {
        // 搜索至末位，将结果加入 res
        if (index == chars.length - 1) {
            res.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            // 当前字符已存在于当前位置，跳过
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(index, i);
            search(index + 1);
            swap(index, i);
        }
    }

    private void swap(int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}