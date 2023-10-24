package pers.chris.Str.countSeniors;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/23
 */
class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            int n = detail.length();
            String ageStr = detail.substring(n - 4, n - 2);
            int age = Integer.parseInt(ageStr);
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}
