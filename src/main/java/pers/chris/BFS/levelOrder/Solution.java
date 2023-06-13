package pers.chris.BFS.levelOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import pers.chris.BinaryTree.TreeNode;

/**
 * @Description
 * @Author Chris
 * @Date 2023/3/23
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        List<Integer> res = new ArrayList<>();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node.left != null) {
                nodes.addLast(node.left);
            }
            if (node.right != null) {
                nodes.addLast(node.right);
            }
            res.add(node.val);
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}