package com.medium;

import com.domain.ListNode;
import com.domain.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

public class M109_ConvertSortedListToBinarySearchTree3 {
    private ArrayList<Integer> arr = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        while(p != null){
            this.arr.add(p.val);
            p = p.next;
        }
        return convertListToBST(0, this.arr.size() - 1);
    }

    public TreeNode convertListToBST(int l, int r){
        if(l > r){
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(this.arr.get(mid));
        if(l == r){ // 仅存一个结点，跳过下面加速！
            return node;
        }
        node.left = convertListToBST(l, mid - 1);
        node.right = convertListToBST(mid + 1, r);
        return node;
    }

    @Test
    public void t(){
        int[] arr = {1, 2, 3, 4, 5};

        ListNode head = new ListNode(-1);
        ListNode list = head;
        for(int i = 0; i < arr.length; i++){
            list.next = new ListNode(arr[i]);
            list = list.next;
        }
        TreeNode tree = sortedListToBST(head.next);
    }
}
