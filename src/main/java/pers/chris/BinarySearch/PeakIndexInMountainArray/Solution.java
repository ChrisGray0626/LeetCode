package pers.chris.BinarySearch.PeakIndexInMountainArray;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid + 1]) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return l;
    }
}
