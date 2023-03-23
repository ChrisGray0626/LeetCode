package pers.chris.BinaryTree.Flatten;

import pers.chris.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preOrder(root, list);

        for (int i = 1; i < list.size(); i ++){
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    public void preOrder(TreeNode node, List<TreeNode> list){
        if (node != null){
            list.add(node);
        }
        else {
            return;
        }

        preOrder(node.left, list);
        preOrder(node.right, list);
    }
}
