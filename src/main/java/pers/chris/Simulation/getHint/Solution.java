package pers.chris.Simulation.getHint;

class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int bull = 0, cow = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];

        for (int i = 0; i < n; i++) {
            char chS = secret.charAt(i);
            char chG = guess.charAt(i);
            if (chS == chG) {
                bull++;
            }
            else {
                cntS[chS - '0']++;
                cntG[chG - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cow += Math.min(cntS[i], cntG[i]);
        }
        return bull + "A" + cow + "B";
    }
}
