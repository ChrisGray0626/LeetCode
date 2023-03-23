package pers.chris.BFS.mirrorTree;

import pers.chris.BinaryTree.TreeNode;

import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author Chris
 * @Date 2023/3/22
 */
class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        bfs(root);

        return root;
    }

    public void bfs(TreeNode node) {
        if (null == node) {
            return;
        }

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        bfs(node.left);
        bfs(node.right);
    }
}
