package pers.chris.LinkedList.RverseBetween;

import pers.chris.LinkedList.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i ++){
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i ++){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
