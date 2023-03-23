package pers.chris.Contest.Single256.kthLargestNumber;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int len = nums.length;

        Arrays.sort(nums, (num1, num2) -> {
            if (num1.length() == num2.length()) {
                return num2.compareTo(num1);
            }
            else {
                return num2.length() - num1.length();
            }
        });
        return nums[k];
    }

    public int MyCompare(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return 1;
        }
        else if (num1.length() < num2.length()) {
            return -1;
        }
        else {
            int idx = 0;
            while (idx < num1.length()) {
                if (num1.charAt(idx) > num2.charAt(idx)) {
                    return 1;
                }
                else if (num1.charAt(idx) < num2.charAt(idx)) {
                    return -1;
                }
                idx++;
            }
            return 0;
        }
    }
}
