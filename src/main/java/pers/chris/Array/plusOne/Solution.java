package pers.chris.Array.plusOne;

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            carry = digits[i] == 10 ? 1 : 0;
            digits[i] %= 10;
        }

        if (carry == 1) {
            digits = new int[n + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
