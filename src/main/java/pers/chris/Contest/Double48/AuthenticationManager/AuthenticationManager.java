package pers.chris.Contest.Double48.AuthenticationManager;

import java.util.HashMap;
import java.util.Map;

class AuthenticationManager {

    private int timeToLive;
    Map<String, Integer> map = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (!map.containsKey(tokenId)){
            return;
        }
        int setTime = map.get(tokenId);
        if (setTime + timeToLive > currentTime){
            map.put(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Integer setTime: map.values()){
            if (setTime + timeToLive > currentTime){
                count ++;
            }
        }
        return count;
    }
}
