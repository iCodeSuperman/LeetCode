package second;

import com.domain.ListNode;

/**
 * 024 两两交换链表中的节点
 */
public class Q024 {
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    public ListNode swap(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode nxt = head.next;
        ListNode successor = nxt.next;
        nxt.next = head;
        head.next = swap(successor);
        return nxt;
    }
}
