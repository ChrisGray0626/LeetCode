package pers.chris.Hash.UnCommonFromSentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] strA = A.split(" ");
        String[] strB = B.split(" ");

        for (String str: strA){
            int value = map.getOrDefault(str, 0);
            map.put(str, ++ value);
        }

        for (String str: strB){
            int value = map.getOrDefault(str, 0);
            map.put(str, ++ value);
        }

        List<String> res = new ArrayList<>();

        for (String key: map.keySet()){
            if (map.get(key) == 1){
                res.add(key);
            }
        }

        return res.toArray(new String[0]);
    }
}
