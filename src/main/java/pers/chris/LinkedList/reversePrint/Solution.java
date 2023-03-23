package pers.chris.LinkedList.reversePrint;

import pers.chris.LinkedList.ListNode;

import java.util.Stack;

class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int sum = stack.size();
        int[] res = new int[sum];

        for (int i = 0; i < sum; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
