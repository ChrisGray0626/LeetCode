package pers.chris.DFS.flatten;


class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {
        Node cur = node;
        Node last = null; // 当前子链的末位节点

        while (cur != null) {
            Node next = cur.next;
            Node child = cur.child;

            // 优先处理子节点
            if (child != null) {
                Node childLast = dfs(child);

                // cur与child连接
                cur.next = child;
                child.prev = cur;

                // childLast与next连接
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                cur.child = null; // 子节点断连
                last = childLast; // 更新末位节点
            }
            // 没有子节点，则当前子链的末位节点为当前节点
            else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
