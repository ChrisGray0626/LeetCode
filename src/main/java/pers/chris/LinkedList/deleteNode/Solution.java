package pers.chris.LinkedList.deleteNode;

import pers.chris.LinkedList.ListNode;

class Solution {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) {
            return head.next;
        }
        ListNode node = head;
        while(node.next != null && node.next.val != val) {
            node = node.next;
        }
        if(node.next != null) {
            node.next = node.next.next;
        }
        return head;
    }
}
