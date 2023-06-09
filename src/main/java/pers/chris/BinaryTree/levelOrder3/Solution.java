package pers.chris.BinaryTree.levelOrder3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pers.chris.BinaryTree.TreeNode;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/8
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();

        if (root == null) {
            return res;
        }

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            List<TreeNode> nextLevelNodes = new ArrayList<>();

            for (TreeNode node : queue) {
                levelValues.add(node.val);
                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }

            if (level % 2 == 1) {
                Collections.reverse(levelValues);
            }

            res.add(levelValues);
            queue = nextLevelNodes;
            level++;
        }
        return res;
    }
}