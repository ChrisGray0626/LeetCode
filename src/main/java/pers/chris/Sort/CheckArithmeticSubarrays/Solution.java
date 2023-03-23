package pers.chris.Sort.CheckArithmeticSubarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> res = new ArrayList<Boolean>();

        for (int i = 0; i < l.length; i ++){
            int[] helper = Arrays.copyOfRange(nums, l[i], r[i] + 1);

            Arrays.sort(helper);

            boolean flag = true;
            for (int j = 0; j < helper.length - 1; j ++){
                if (helper[j] - helper[j + 1] != helper[0] - helper[1]){
                    flag = false;
                    break;
                }
            }
            res.add(flag);
        }
        return res;
    }
}
