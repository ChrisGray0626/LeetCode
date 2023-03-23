package pers.chris.BinaryTree.LevelOrder;

import pers.chris.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<List<Integer>>();
        if (root == null){
            return levelList;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int curSize = queue.size();
            List<Integer> level = new ArrayList<Integer>();

            for (int i = 0; i < curSize; i ++){
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }

            levelList.add(level);
        }

        return levelList;
    }
}
