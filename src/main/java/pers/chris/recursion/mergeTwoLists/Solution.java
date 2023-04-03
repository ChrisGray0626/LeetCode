package pers.chris.recursion.mergeTwoLists;

import pers.chris.LinkedList.ListNode;

/**
 * @Description
 * @Author Chris
 * @Date 2023/4/2
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else {
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }
}
