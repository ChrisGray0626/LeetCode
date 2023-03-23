package pers.chris.BinaryTree.PathSum;

import pers.chris.BinaryTree.TreeNode;

public class Solution {

    public boolean flag = false;
    public int SUM;
    public boolean hasPathSum(TreeNode root, int sum) {
        SUM = sum;
        getPathSum(root, 0);
        return flag;
    }

    public void getPathSum(TreeNode node, int pathSum){
        if (node == null){
            return;
        }
        pathSum += node.val;

        if (node.left == null && node.right == null){
            if (pathSum == SUM){
                flag = true;
            }
            return;
        }

        getPathSum(node.left, pathSum);
        getPathSum(node.right, pathSum);
    }
}
