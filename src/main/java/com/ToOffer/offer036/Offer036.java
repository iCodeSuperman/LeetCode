package com.ToOffer.offer036;

/**
 * @author icodeboy
 */
public class Offer036 {
    private Node pre = null;
    private Node head, tail;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return root;
        }
        inOrder(root);

        Node p = head;
        while(p.right != null){
            p = p.right;
        }
        tail = p;
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(pre == null){
            head = root;
            pre = root;
        }else{
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        inOrder(root.right);
    }
}




/**
 * Definition for a Node.
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

