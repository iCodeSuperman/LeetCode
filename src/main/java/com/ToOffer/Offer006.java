package com.ToOffer;

import com.domain.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Offer006 {
    private List<Integer> list;
    public int[] reversePrint(ListNode head) {
        list = new ArrayList<>();
        reverse(head);
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void reverse(ListNode p){
        if(p == null){
            return;
        }
        reverse(p.next);
        list.add(p.val);
    }
}
