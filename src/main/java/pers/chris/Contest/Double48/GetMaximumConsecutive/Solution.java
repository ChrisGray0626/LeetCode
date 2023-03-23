package pers.chris.Contest.Double48.GetMaximumConsecutive;

import java.util.*;

class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int res = 0;
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i ++){
            if (coins[i] <= res + 1){
                res += coins[i];
            }
            else {
                break;
            }
        }
        return res + 1;
    }
}
