package pers.chris.Math.CheckRecord;

class Solution {
    public boolean checkRecord(String s) {
        int len = s.length();
        int cntAbsent = 0;
        int cntLate = 0;
        int cntContinueLate = 0;

        for (int i = 0; i < len; i ++) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'A':
                    cntAbsent ++;
                    cntLate = 0;
                    cntContinueLate = 0;
                    break;
                case 'L':
                    cntLate ++;
                    cntContinueLate ++;
                    break;
                case 'P':
                    cntLate = 0;
                    cntContinueLate = 0;
                    break;
            }
            if (cntContinueLate == 3) {
                return false;
            }
        }
        if (cntAbsent >= 2 || cntLate > 3) {
            return false;
        }
        else {
            return true;
        }
    }
}
