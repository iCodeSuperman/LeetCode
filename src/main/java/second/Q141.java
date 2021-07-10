package second;

import com.domain.ListNode;

/**
 * 141. 环形链表
 * @author icodeboy
 */
public class Q141 {
    public boolean hasCycle(ListNode head) {
        boolean res = false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                res = true;
                break;
            }
        }
        return res;
    }
}
