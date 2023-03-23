package pers.chris.BinarySearch.singleNonDuplicate;

class Solution {

    private int[] nums;
    public int singleNonDuplicate(int[] nums) {
        this.nums = nums;
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (searchSingle(mid)) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return nums[l];
    }

    public boolean searchSingle(int idx) {
        if (idx % 2 == 1) {
            return nums[idx] == nums[idx - 1];
        }
        else {
            return nums[idx] == nums[idx + 1];
        }
    }
}
