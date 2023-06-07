package pers.chris.recursion.isSubStructure;

import pers.chris.BinaryTree.TreeNode;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/7
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        return isContained(A, B) || (A != null && (isSubStructure(A.left, B) || isSubStructure(A.right, B)));
    }

    private boolean isContained(TreeNode A, TreeNode B) {
        // B 遍历结束，说明 B 是 A 的子结构
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return isContained(A.left, B.left) && isContained(A.right, B.right);
    }
}