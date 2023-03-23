package pers.chris.Stack.CountOfAtoms;

import java.util.*;

class Solution {
    String formula;
    int len;
    int i = 0;

    public String countOfAtoms(String formula) {
        this.formula = formula;
        len = formula.length();
        if (len == 0) {
            return "";
        }

        Deque<Map<String, Integer>> stack = new LinkedList<>();
        stack.push(new HashMap<>());
        int i = 0;
        while (i < len) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                i ++;
                stack.push(new HashMap<>());
            }
            else if (ch == ')') {
                i ++;
                int num = parseNum();
                Map<String, Integer> popMap = stack.pop();
                Map<String, Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> entry: popMap.entrySet()) {
                    String atom = entry.getKey();
                    int value = entry.getValue();
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + value * num);
                }
            }
            else {
                String atom = parseAtom();
                int num = parseNum();
                Map<String, Integer> topMap = stack.peek();
                topMap.put(atom, topMap.getOrDefault(atom, 0) + num);
            }
        }

        Map<String, Integer> map = stack.pop();
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public String parseAtom() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(formula.charAt(i));
        stringBuilder.append(formula.charAt(i ++));

        while (i < len && Character.isLowerCase(formula.charAt(i))) {
            stringBuilder.append(formula.charAt(i ++));
        }
        return stringBuilder.toString();
    }

    public Integer parseNum() {
        if (i == len || !Character.isDigit(formula.charAt(i))) {
            return 1;
        }

        int num = 0;
        while (i < len && Character.isDigit(formula.charAt(i))) {
            num = num * 10 + formula.charAt(i ++) - '0';
        }
        return num;
    }
}
