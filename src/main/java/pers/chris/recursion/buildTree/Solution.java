package pers.chris.recursion.buildTree;

import javafx.util.Pair;
import pers.chris.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Integer, Integer> idxMap = new HashMap<>();
    int[] preOrder;
    int[] inOrder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inOrder = inorder;
        int end = inorder.length - 1;
        // 构建中序遍历的索引，加快查找
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        return buildTree(0, end, 0, end);
    }

    private TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd) {
        // 左边界大于右边界，递归终止
        if (preStart > preEnd) {
            return null;
        }
        // 前序遍历的第一个节点为根节点
        int preRootIdx = preStart;
        int rootVal = preOrder[preRootIdx];
        int inRootIdx = idxMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        // 前序遍历的左子树的左边界为前序遍历的第二个节点
        int preLeftStart = preStart + 1;
        // 左子树的节点数为中序遍历的根节点减去中序遍历的左边界
        int leftSize = inRootIdx - inStart;
        // 前序遍历的左子树的右边界为前序遍历的左子树的左边界加上左子树的节点数减一
        int preLeftEnd = preLeftStart + leftSize - 1;
        // 中序遍历的左子树的左边界为中序遍历的左边界
        int inLeftStart = inStart;
        // 中序遍历的左子树的右边界为中序遍历的根节点减一
        int inLeftEnd = inRootIdx - 1;
        root.left = buildTree(preLeftStart, preLeftEnd, inLeftStart, inLeftEnd);
        // 前序遍历的右子树的左边界为前序遍历的左子树的右边界加一
        int preRightStart = preLeftEnd + 1;
        // 前序遍历的右子树的右边界为前序遍历的右边界
        int preRightEnd = preEnd;
        // 中序遍历的右子树的左边界为中序遍历的根节点加一
        int inRightStart = inRootIdx + 1;
        // 中序遍历的右子树的右边界为中序遍历的右边界
        int inRightEnd = inEnd;
        root.right = buildTree(preRightStart, preRightEnd, inRightStart, inRightEnd);

        return root;
    }
}
