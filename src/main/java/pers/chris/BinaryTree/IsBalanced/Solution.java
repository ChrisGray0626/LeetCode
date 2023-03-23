package pers.chris.BinaryTree.IsBalanced;

import pers.chris.BinaryTree.TreeNode;

public class Solution {

    public boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        getLength(root);
        return flag;
    }

    public int getLength(TreeNode node){
        if (node == null){
            return 1;
        }

        int lengthLeft = getLength(node.left) + 1;
        int lengthRight = getLength(node.right) + 1;

        if (Math.abs(lengthLeft - lengthRight) > 1){
            flag = false;
        }

        return Math.max(lengthLeft, lengthRight);
    }
}
