package pers.chris.findReplaceString;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description
 * @Author Chris
 * @Date 2023/8/14
 */
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder res = new StringBuilder(s);
        int offset = 0;
        int[] sortedIndices = argSort(indices);
        for (int sortedIndex : sortedIndices) {
            int index = indices[sortedIndex] + offset;
            String source = sources[sortedIndex];
            String target = targets[sortedIndex];
            int sourceLen = source.length();
            if (index + sourceLen <= res.length() && res.substring(index, index + sourceLen).equals(source)) {
                res.replace(index, index + sourceLen, target);
                offset += target.length() - sourceLen;
            }
        }
        return res.toString();
    }

    private int[] argSort(final int[] array) {
        Integer[] indices = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(index -> array[index]));
        return Arrays.stream(indices).mapToInt(Integer::valueOf).toArray();
    }
}
