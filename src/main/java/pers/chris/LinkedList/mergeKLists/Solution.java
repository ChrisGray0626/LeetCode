package pers.chris.LinkedList.mergeKLists;

import pers.chris.LinkedList.ListNode;

/**
 * @Description
 * @Author Chris
 * @Date 2023/8/12
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        else {
            int mid = (left + right) / 2;
            ListNode l1 = merge(lists, left, mid);
            ListNode l2 = merge(lists, mid + 1, right);
            return merge2List(l1, l2);
        }
    }

    private ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge2List(l1.next, l2);
            return l1;
        }
        else {
            l2.next = merge2List(l2.next, l1);
            return l2;
        }
    }
}