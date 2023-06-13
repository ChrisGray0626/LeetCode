package pers.chris.pathSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pers.chris.BinaryTree.TreeNode;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/9
 */
class Solution {

    private final List<List<Integer>> paths = new ArrayList<>();
    private int target;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;

        search(root, new ArrayList<>());

        return paths;
    }

    public void search(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            // List 求和
            int sum = path.stream().mapToInt(Integer::intValue).sum();
            if (sum == target) {
                paths.add(new ArrayList<>(path));
            }
        }
        search(root.left, path);
        search(root.right, path);

        path.remove(path.size() - 1);
    }
}