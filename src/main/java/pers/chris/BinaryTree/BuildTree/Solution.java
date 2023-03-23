package pers.chris.BinaryTree.BuildTree;

import pers.chris.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    int[] inOrder;
    int[] postOrder;
    int postIdx;
    Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder = inorder;
        postOrder = postorder;
        postIdx = postOrder.length - 1;

        for (int i = 0; i < inOrder.length; i ++){
            idxMap.put(inOrder[i], i);
        }

        return build(0, inOrder.length - 1);
    }

    public TreeNode build(int inStart, int inEnd){
        if (inStart > inEnd){
            return null;
        }

        int rootVal = postOrder[postIdx];
        TreeNode node = new TreeNode(rootVal);
        int inIdx = idxMap.get(rootVal);

        postIdx --;
        node.right = build(inIdx + 1, inEnd);
        node.left = build(inStart, inIdx - 1);

        return node;
    }
}
