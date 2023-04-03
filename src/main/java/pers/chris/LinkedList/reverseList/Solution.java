package pers.chris.LinkedList.reverseList;

import pers.chris.LinkedList.ListNode;

/**
 * @Description
 * @Author Chris
 * @Date 2023/4/2
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        if (null == head) {
            return null;
        }
        ListNode cur = head.next;
        head.next = null;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
