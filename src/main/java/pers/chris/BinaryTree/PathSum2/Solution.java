package pers.chris.BinaryTree.PathSum2;

import pers.chris.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Integer>> pathList = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getPathSum(root, sum);
        return pathList;
    }

    public void getPathSum(TreeNode node, int sum){
        if (node == null){
            return;
        }

        sum -= node.val;
        path.add(node.val);

        if (node.left == null && node.right == null && sum == 0){
            pathList.add(new ArrayList<>(path));
        }

        getPathSum(node.left, sum);
        getPathSum(node.right, sum);

        path.remove(path.size() - 1);
    }
}
