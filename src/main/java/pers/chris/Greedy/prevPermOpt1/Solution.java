package pers.chris.Greedy.prevPermOpt1;

/**
 * @Description
 * @Author Chris
 * @Date 2023/4/2
 */
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            int num = arr[i];
            int max = -1;
            int maxIdx = -1;
            boolean flag = false;
            for (int j = i + 1; j < n ; j++) {
                if (arr[j] < num && arr[j] > max) {
                    max = arr[j];
                    maxIdx = j;
                    flag = true;
                }
            }
            if (flag) {
                int tmp = arr[maxIdx];
                arr[maxIdx] = arr[i];
                arr[i] = tmp;
                break;
            }
        }

        return arr;
    }
}
