package pers.chris.Sort.SortListNode;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null){
            while (pre.next != null && pre.next.val <= cur.val){
                pre = pre.next;
            }

            ListNode tmp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = tmp;
            pre = dummy;
        }

        return dummy.next;
    }
}
