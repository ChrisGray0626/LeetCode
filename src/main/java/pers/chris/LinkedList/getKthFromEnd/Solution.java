package pers.chris.LinkedList.getKthFromEnd;

import pers.chris.LinkedList.ListNode;

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode l = head;
        ListNode r = head;
        for (int i = 0; i < k; i++) {
            r = r.next;
        }
        while (r != null) {
            l = l.next;
            r = r.next;
        }
        return l.next;
    }
}
