package pers.chris.BinarySearch.SearchRotatedSortedArray;

class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l ++;
                r --;
            }
            else if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
