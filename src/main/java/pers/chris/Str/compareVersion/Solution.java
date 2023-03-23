package pers.chris.Str.compareVersion;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");

        for (int i = 0; i < Math.max(v1Arr.length, v2Arr.length); i++) {
            int num1 = 0;
            int num2 = 0;
            if (i < v1Arr.length) {
                num1 = Integer.parseInt(v1Arr[i]);

            }
            if (i < v2Arr.length) {
                num2 = Integer.parseInt(v2Arr[i]);

            }
            if (num1 > num2) {
                return 1;
            }
            else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}
