package pers.chris.Divide.TreeToDoublyList;

public class Solution {

    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }

        dfs(root);
        pre.right = head;
        head.left = pre;

        return head;
    }

    public void dfs(Node cur){
        if (cur == null){
            return;
        }

        dfs(cur.left);

        if (pre == null){
            head = cur;
        }
        else {
            pre.right = cur;
        }

        cur.left = pre;
        pre = cur;

        dfs(cur.right);
    }
}
