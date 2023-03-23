package pers.chris.BinarySearch.TwoSum;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] < target) {
                l ++;
            }
            else if (numbers[l] + numbers[r] > target) {
                r --;
            }
            else {
                return new int[] {++ l, ++ r};
            }
        }
        return new int[] {++ l, ++ r};
    }
}
