package second;

import com.domain.ListNode;

/**
 * 022 链表倒数第K个结点
 * @author icodeboy
 */
public class Offer022 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && k > 0){
            fast = fast.next;
            k--;
        }



        if(fast == null){
            return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow.next;
    }
}
