package pers.chris.BinaryTree.BuildBST;

import pers.chris.BinaryTree.TreeNode;

public class Solution {

    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;

        return build(0, nums.length - 1);
    }

    public TreeNode build(int left, int right){
        if (left > right){
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = build(left, mid - 1);
        node.right = build(mid + 1, right);

        return node;
    }
}
