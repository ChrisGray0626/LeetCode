package pers.chris.BinarySearch.minArray;

public class Solution {

    public int minArray(int[] numbers) {
        int n = numbers.length;
        int l = 0;
        int r = n - 1;
        // 排除末尾与首位相等的情况
        while (l < r && numbers[r] == numbers[0]) {
            r--;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] < numbers[0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // 排除本身有序的情况
        return Math.min(numbers[l], numbers[0]);
    }
}
