package pers.chris.LinkedList.deleteNode;

import pers.chris.LinkedList.ListNode;

class Solution {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
