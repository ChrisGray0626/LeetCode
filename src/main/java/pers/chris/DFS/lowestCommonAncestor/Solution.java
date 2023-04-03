package pers.chris.DFS.lowestCommonAncestor;

import pers.chris.BinaryTree.TreeNode;

/**
 * @Description
 * @Author Chris
 * @Date 2023/4/2
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return searchCommonAncestor(root, p, q);
    }

    public TreeNode searchCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (null == node) {
            return null;
        }
        if (node == p || node == q) {
            return node;
        }

        TreeNode left = searchCommonAncestor(node.left, p, q);
        TreeNode right = searchCommonAncestor(node.right, p, q);

        if (null == left) {
            return right;
        }
        if (null == right) {
            return left;
        }

        return node;
    }
}
