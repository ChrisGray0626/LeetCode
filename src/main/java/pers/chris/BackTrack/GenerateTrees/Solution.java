package pers.chris.BackTrack.GenerateTrees;

import pers.chris.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> treeNodes = new LinkedList<>();
        // 左结点大于右结点，不符合搜索树
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }

        for (int i = start; i <= end; i ++) {
            // 回溯生成左右子树的集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 任选左右子树集合的各一子树成为当前节点的左右子树
            for (TreeNode left: leftTrees) {
                for (TreeNode right: rightTrees) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    treeNodes.add(cur);
                }
            }
        }
        return treeNodes;
    }
}
