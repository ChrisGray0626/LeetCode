package pers.chris.Hash.FindDuplicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path: paths){
            String[] value = path.split(" ");
            for (int i = 1; i < value.length; i ++){
                String[] fileName = value[i].split("\\(");
                fileName[1] = fileName[1].replace(")", "");
                List<String> list = map.getOrDefault(fileName[1], new ArrayList<String>());
                list.add(value[0] + "/" + fileName[0]);
                map.put(fileName[1], list);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (String key: map.keySet()){
            if (map.get(key).size() > 1){
                res.add(map.get(key));
            }
        }

        return res;
    }
}
