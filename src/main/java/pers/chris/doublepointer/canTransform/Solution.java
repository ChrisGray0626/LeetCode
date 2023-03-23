package pers.chris.doublepointer.canTransform;

class Solution {

    private final static char CHAR_X = 'X';
    private final static char CHAR_L = 'L';
    private final static char CHAR_R = 'R';

    public boolean canTransform(String start, String end) {
        int i = 0;
        int j = 0;
        int n = start.length();
        // 双指针同时遍历
        while (i < n && j < n) {
            // 找到下一个不为 X 的字符
            while (i < n && start.charAt(i) == CHAR_X) {
                i++;
            }
            while (j < n && end.charAt(j) == CHAR_X) {
                j++;
            }

            if (i < n && j < n) {
                // 如果两个字符不相等，说明顺序不一致
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }

                char ch = start.charAt(i);
                // 字符为 L，i 应小于 j
                if (ch == CHAR_L && j > i) {
                    return false;
                }
                // 字符为 R，i 应大于 j
                if (ch == CHAR_R && j < i) {
                    return false;
                }

                i++;
                j++;
            }
        }
        // 如果有剩余的非 X 字符，说明顺序不一致
        while (i < n) {
            if (start.charAt(i) != CHAR_X) {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != CHAR_X) {
                return false;
            }
            j++;
        }
        return true;
    }
}
