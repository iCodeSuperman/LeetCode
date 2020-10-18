package com.medium;

import com.domain.Node;

public class M117_PopulatingNextRightPointersInEachNode2 {
    public Node connect(Node root) {
        if(root == null) return null;

        Node leftmost = root;
        while(leftmost != null){
            Node cur = leftmost; //第N层左边第一个结点cur
            Node pre = null; //第N+1层左边第一个结点pre
            leftmost = null; //置为null，等待后面更新，否则会在最后一层死循环
            boolean flag = true; //true表示还没找到左边第一个结点
            while(cur != null){
                //1. 对于每一个cur结点，都遍历左孩子和右孩子
                //2. 当flag为true，表示没找到N+1层的第一个结点，找到后 pre=第一个结点
                //3. 当flag为false，只需要更新 pre.next=子节点; pre=pre.next;
                if(cur.left != null){
                    if(flag){ //第N+1层找到左边第一个结点，标记为pre
                        pre = cur.left;
                        flag = false;
                        leftmost = pre; //这里更新leftmost
                    }else{
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if(cur.right != null){
                    if(flag){
                        pre = cur.right;
                        flag = false;
                        leftmost = pre;
                    }else{
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
        }
        return root;
    }
}
