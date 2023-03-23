package pers.chris.Divide.PrintNumbers;

class Solution {

    StringBuilder res = new StringBuilder();
    int n, nineSum = 0, start; // 左开始边界，删除高位0
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8','9'};
    char[] num;
    public String printNumbers(int n) {
        this.n = n;
        start = n - 1;
        num = new char[n];

        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public void dfs(int digit){
        if (digit == n){
            String nums = String.valueOf(num).substring(start);

            if (!nums.equals("0")) {
                res.append(nums).append(",");
            }

            if (n - start == nineSum){
                start --;
            }
            return;
        }

        for (char s: loop){
            if (s == '9'){
                nineSum ++;
            }

            num[digit] = s;
            dfs(digit + 1);
        }
        nineSum --;
    }
}
