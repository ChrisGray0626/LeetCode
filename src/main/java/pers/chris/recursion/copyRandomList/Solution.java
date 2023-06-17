package pers.chris.recursion.copyRandomList;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/13
 */
class Solution {

    private final Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        return copy(head);
    }

    private Node copy(Node node) {
        if (node == null) {
            return null;
        }
        // 如果该节点已经被复制过，则直接返回
        if (!map.containsKey(node)) {
            Node newNode = new Node(node.val);
            // 先将新节点放入 map 中，再递归复制 next 和 random
            map.put(node, newNode);
            newNode.next = copy(node.next);
            newNode.random = copy(node.random);
        }
        return map.get(node);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}