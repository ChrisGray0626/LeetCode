package pers.chris.Str.ReverseStr;


class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] arr = s.toCharArray();

        for (int i = 0; i < len; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, len) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
