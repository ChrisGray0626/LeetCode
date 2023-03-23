package pers.chris.Hash.GroupAnagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

        for (String str: strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = Arrays.toString(ch);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
