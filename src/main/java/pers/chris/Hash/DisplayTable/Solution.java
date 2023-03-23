package pers.chris.Hash.DisplayTable;

import java.util.*;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foods = new TreeSet<>();
        Set<Integer> tables = new TreeSet<>();
        Map<Integer, Map<String, Integer>> orderMap = new HashMap<>();

        for (List<String> order: orders) {
            Integer table = Integer.valueOf(order.get(1));
            String food = order.get(2);
            foods.add(food);
            tables.add(table);
            Map<String, Integer> tableOrder = orderMap.getOrDefault(table, new HashMap<>());
            int foodNum = tableOrder.getOrDefault(food, 0) + 1;
            tableOrder.put(food, foodNum);
            orderMap.put(table, tableOrder);
        }

        List<List<String>> res = new ArrayList<>();
        List<String> firstList = new ArrayList<>();
        firstList.add("Table");
        firstList.addAll(foods);
        res.add(firstList);

        for (Integer table: tables) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(table));
            Map<String, Integer> tableOrder = orderMap.get(table);
            for (String food: foods) {
                list.add(String.valueOf(tableOrder.getOrDefault(food, 0)));
            }
            res.add(list);
        }
        return res;
    }
}
