package pers.chris.Contest.Single233.MaxValue;

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int count = 1;
        int i = 0;
        int sum = n;
        while (true){
            i ++;
            i = Math.min(i, n);
            sum += i;
            if (sum <= maxSum){
                count ++;
            }
            else {
                break;
            }
        }
        if (index != 0 && index != n - 1){
            return maxValue(n - 1, 0, maxSum - count);
        }
        return count;
    }
}
