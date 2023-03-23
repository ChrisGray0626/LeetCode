package pers.chris.DFS.VerticalTraversal;

import pers.chris.BinaryTree.TreeNode;

import java.util.*;

class Solution {
    Map<Integer, Map<Integer, List<Integer>>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, 0);


        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (int key: keys) {
            Map<Integer, List<Integer>> map1 = map.get(key);
            List<Integer> keys1 = new ArrayList<>(map1.keySet());
            Collections.sort(keys1);
            List<Integer> list = new ArrayList<>();
            for (Integer key1: keys1) {
                List<Integer> list1 = map1.get(key1);
                Collections.sort(list1);
                list.addAll(list1);
            }
            res.add(list);
        }
        return res;
    }

    public void dfs(TreeNode node, int idx, int layer) {
        if (node == null) {
            return;
        }

        Map<Integer, List<Integer>>map1 = map.getOrDefault(idx, new HashMap<>());
        List<Integer> list = map1.getOrDefault(layer, new ArrayList<>());
        list.add(node.val);
        map1.put(layer, list);
        map.put(idx, map1);

        dfs(node.left, idx - 1, layer + 1);
        dfs(node.right, idx + 1, layer + 1);
    }
}
