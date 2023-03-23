package pers.chris.Math.rand10;

class Solution extends SolBase {
    public int rand10() {
        int rand5, rand2;

        while ((rand5 = rand7()) > 5);
        while ((rand2 = rand7()) > 2);
        return rand2 % 2 * 5 + rand5;
    }
}
