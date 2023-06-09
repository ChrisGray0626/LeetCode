package pers.chris.BinaryTree.verifyPostorder;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/9
 */
class Solution {

    private int[] postorder;

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;

        return verify(0, postorder.length - 1);
    }

    public boolean verify(int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        int idx = start;
        while (idx < end && postorder[idx] < root) {
            idx++;
        }
        int mid = idx;
        while (idx < end && postorder[idx] > root) {
            idx++;
        }
        if (idx != end) {
            return false;
        }
        return verify(start, mid - 1) && verify(mid, end - 1);
    }
}