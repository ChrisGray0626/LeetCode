package pers.chris.Greedy.NumRescueBoats;

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int minIdx = 0, maxIdx = people.length - 1;
        int cnt = 0;

        while (minIdx <= maxIdx) {
            if (people[minIdx] + people[maxIdx] <= limit) {
                minIdx++;
            }
            maxIdx--;
            cnt++;
        }
        return cnt;
    }
}
