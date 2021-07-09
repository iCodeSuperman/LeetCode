package second;

import com.domain.ListNode;

/**
 * 142. 环形链表
 * @author icodeboy
 *
 */
public class Q142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null){
            return null;
        }

        ListNode point = head;
        while(point != slow){
            point = point.next;
            slow = slow.next;
        }

        return slow;
    }
}
