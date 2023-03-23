package pers.chris.Str.CompressString;

class Solution {
    public String compressString(String S) {
        if (S.length() == 0){
            return S;
        }

        int sum = 1;
        char ch = S.charAt(0);
        StringBuffer res = new StringBuffer();

        for (int i = 1; i < S.length(); i ++){
            if (ch == S.charAt(i)){
                sum ++;
            }
            else {
                res.append(ch);
                res.append(sum);
                ch = S.charAt(i);
                sum = 1;
            }
        }

        res.append(ch);
        res.append(sum);

        return res.length() < S.length() ? res.toString() : S;
    }
}