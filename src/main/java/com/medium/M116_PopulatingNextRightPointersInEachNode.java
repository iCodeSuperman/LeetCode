package com.medium;

import com.domain.Node;

public class M116_PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root == null) return root;

        Node leftMost = root;
        while(leftMost.left != null){
            Node head = leftMost;
            while(head != null){
                head.left.next = head.right;
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }


    public Node connect2(Node root){
        if(root == null){
            return root;
        }
        order(root);
        return root;
    }
    public void order(Node root){
        if(root.left == null || root.right == null){
            return;
        }
        root.left.next = root.right;
        if(root.next == null){
            root.right.next = null;
        }else{
            root.right.next = root.next.left;
        }
        order(root.left);
        order(root.right);

    }
}
