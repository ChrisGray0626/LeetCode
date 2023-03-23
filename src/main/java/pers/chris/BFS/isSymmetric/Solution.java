package pers.chris.BFS.isSymmetric;

import pers.chris.BinaryTree.TreeNode;

/**
 * @Description
 * @Author Chris
 * @Date 2023/3/22
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }

        return bfs(root.left, root.right);
    }

    public boolean bfs(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }

        return p.val == q.val && bfs(p.left, q.right) && bfs(p.right, q.left);
    }
}
