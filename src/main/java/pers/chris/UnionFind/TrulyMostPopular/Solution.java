package pers.chris.UnionFind.TrulyMostPopular;

import java.util.*;

class Solution {

    Map<String, String> parent = new HashMap<>();

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        for (String name: names){
            name = name.split("\\(")[0];
            parent.put(name, name);
        }

        for (String synonym: synonyms){
            String name1 = synonym.split(",")[0].replace("(", "");
            String name2 = synonym.split(",")[1].replace(")", "");

            if (!parent.containsKey(name1)){
                parent.put(name1, name1);
            }
            if (!parent.containsKey(name2)){
                parent.put(name2, name2);
            }
            merge(name1, name2);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String name: names){
            String root = find(name.split("\\(")[0]);
            int num = Integer.parseInt(name.split("\\(")[1].replace(")", ""));
            int value = map.getOrDefault(root, 0) + num;
            map.put(root, value);
        }

        List<String> res = new ArrayList<>();
        for (String key: map.keySet()){
            String s = key + "(" + map.get(key) + ")";
            res.add(s);
        }

        return res.toArray(new String[0]);

    }

    public String find(String x){
        String root = x;
        while (!parent.get(root).equals(root)){
            root = parent.get(root);
        }

        while (!x.equals(root)){
            parent.put(x, root);
            x = parent.get(x);
        }

        return root;
    }

    public void merge(String x, String y){
        String findX = find(x);
        String findY = find(y);

        if (!findX.equals(findY)){
            if (findX.compareTo(findY) > 0){
                parent.put(findX, findY);
            }
            else {
                parent.put(findY, findX);
            }
        }
    }
}
