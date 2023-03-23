package pers.chris.BinaryTree.IsSymmetric;

import pers.chris.BinaryTree.TreeNode;

class Solution {

    boolean flag = true;

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        check(root.left, root.right);
        return flag;
    }

    public void check(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return;
        }

        if (p == null || q == null || p.val != q.val){
            flag = false;
            return;
        }

        check(p.left, q.right);
        check(p.right, q.left);
    }
}
