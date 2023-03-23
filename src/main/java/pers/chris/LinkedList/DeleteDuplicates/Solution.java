package pers.chris.LinkedList.DeleteDuplicates;

import pers.chris.LinkedList.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                cur = cur.next;

                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            }
            else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
