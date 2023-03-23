package pers.chris.Contest.Double48.SecondHighest;

class Solution {
    public int secondHighest(String s) {
        int[] res = new int[10];

        for (int i = 0; i < s.length(); i ++){
            char ch  = s.charAt(i);
            if (Character.isDigit(ch)){
                int num = Integer.parseInt(String.valueOf(ch));
                res[num] = 1;
            }
        }
        int count = 0;
        for (int i = 9; i >= 0; i --){
            if (res[i] == 1){
                count ++;
            }
            if (count == 2){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.secondHighest("ck077"));
    }
}
