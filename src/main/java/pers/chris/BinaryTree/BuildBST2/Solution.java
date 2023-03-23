package pers.chris.BinaryTree.BuildBST2;

import pers.chris.BinaryTree.TreeNode;

public class Solution {

    ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int length = getLength();

        return build(0, length - 1);

    }
    public int getLength(){
        int length = 0;
        ListNode p = head;
        while (p != null){
            length ++;
            p = p.next;
        }
        return length;
    }

    public TreeNode build(int left, int right){
        if (left > right){
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode();

        node.left = build(left, mid - 1);
        node.val = head.val;
        head = head.next;
        node.right = build(mid + 1, right);

        return node;
    }
}
