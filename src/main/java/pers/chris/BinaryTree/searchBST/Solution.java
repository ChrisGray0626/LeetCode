package pers.chris.BinaryTree.searchBST;

import pers.chris.BinaryTree.TreeNode;

class Solution {

    private int val;

    public TreeNode searchBST(TreeNode root, int val) {
        this.val = val;
        return dfs(root);
    }

    public TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        }
        return dfs(node.val < val ? node.right : node.left);
    }
}
