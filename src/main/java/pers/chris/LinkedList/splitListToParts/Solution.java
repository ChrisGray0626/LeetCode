package pers.chris.LinkedList.splitListToParts;

import pers.chris.LinkedList.ListNode;

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode tmp = head;

        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }

        int quotient = len / k;
        int remain = len % k; // 额外增加节点的part数量

        ListNode[] res = new ListNode[k];
        ListNode cur = head;

        for (int i = 0; i < k && cur != null; i++) {
            // 计算part的实际长度
            int partSize =quotient + (i < remain ? 1 : 0);

            res[i] = cur;
            for (int j = 1; j < partSize; j++) {
                cur = cur.next;
            }

            // part的末位节点断链
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}
