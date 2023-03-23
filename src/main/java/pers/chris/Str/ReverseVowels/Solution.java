package pers.chris.Str.ReverseVowels;


class Solution {

    public String reverseVowels(String s) {
        int len = s.length();
        char[] ss = s.toCharArray();

        int l = 0, r = len - 1;
        while (l < r) {
            while (l < len && !isVowels(ss[l])) {
                l ++;
            }

            while (r > 0 && !isVowels(ss[r])) {
                r --;
            }
            System.out.println(l);
            System.out.println(r);
            if (l < r) {
                char tmp = ss[l];
                ss[l]  = ss[r];
                ss[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(ss);
    }

    public boolean isVowels(char ch) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char vowel : vowels) {
            if (ch == vowel) {
                return true;
            }
        }
        return false;
    }
}
