package pers.chris.BinaryTree.ZigzagLevelOrder;

import pers.chris.BinaryTree.TreeNode;

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if (levelList.size() % 2 == 1){
                Collections.reverse(level);
            }
            levelList.add(level);
        }

        return levelList;
    }
}
