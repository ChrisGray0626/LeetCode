package pers.chris.Sort.Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merge = new ArrayList<int[]>();

        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];

            if (merge.isEmpty() || merge.get(merge.size() - 1)[1] < l) {
                merge.add(new int[]{l, r});
            } else {
                merge.get(merge.size() - 1)[1] = Math.max(r, merge.get(merge.size() - 1)[1]);
            }
        }

        return merge.toArray(new int[merge.size()][]);
    }
}
