package pers.chris.Simulation.findPoisonedDuration;

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int cnt = 0;
        int l = timeSeries[0];
        int r = timeSeries[0];

        for (int time: timeSeries) {
            if (time > r) {
                cnt += (r - l);
                l = time;
            }
            r = time + duration;
        }

        cnt += (r - l);
        return cnt;
    }
}