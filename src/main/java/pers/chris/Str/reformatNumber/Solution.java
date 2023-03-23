package pers.chris.Str.reformatNumber;

class Solution {
    public String reformatNumber(String number) {
        number = number.replaceAll("[\\s-]", "");
        int n = number.length();
        // 剩下的数字个数
        int remain = n % 3;
        int group = n / 3;
        // 余数为1，需要与前面的一组合并
        if (remain == 1) {
            group--;
            remain += 3;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < group; i++) {
            sb.append(number, i * 3, i * 3 + 3);
            sb.append("-");
        }

        if (remain == 2) {
            sb.append(number, n - 2, n);
        }
        else if (remain == 4) {
            sb.append(number, n - 4, n - 2);
            sb.append("-");
            sb.append(number, n - 2, n);
        }
        // 余数为 0，没有剩下的数字，需要去掉最后一个 -
        else {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
