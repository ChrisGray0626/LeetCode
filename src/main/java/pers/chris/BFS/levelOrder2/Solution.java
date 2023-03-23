package pers.chris.BFS.levelOrder2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import pers.chris.BinaryTree.TreeNode;

/**
 * @Description
 * @Author Chris
 * @Date 2023/3/23
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        List<List<Integer>> res = new ArrayList<>();
        while (!nodes.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                assert node != null;
                levelValues.add(node.val);
                if (null != node.left) {
                    nodes.addLast(node.left);
                }
                if (null != node.right) {
                    nodes.addLast(node.right);
                }
            }
            res.add(levelValues);
        }

        return res;
    }
}