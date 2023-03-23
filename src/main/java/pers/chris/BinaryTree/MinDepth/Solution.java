package pers.chris.BinaryTree.MinDepth;

import pers.chris.BinaryTree.TreeNode;

public class Solution {

    public int minDepth(TreeNode root) {
        return getLength(root);
    }

    public int getLength(TreeNode node){
        if (node ==null){
            return 0;
        }

        if (node.left == null && node.right == null){
            return 1;
        }

        int lengthLeft = getLength(node.left) + 1;
        int lengthRight = getLength(node.right) + 1;

        if (node.left == null || node.right == null){
            return Math.max(lengthLeft, lengthRight);
        }

        return Math.min(lengthLeft, lengthRight);
    }
}
