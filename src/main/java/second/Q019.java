package second;


import com.domain.ListNode;

public class Q019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        // slow是待删除的前驱结点（在不是删除头结点的情况下)
        ListNode slow = head;
        while(fast != null && n > 0){
            fast = fast.next;
            n--;
        }
        if(fast == null){
            return head.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode node = slow.next;
        slow.next = node.next;
        node.next = null;

        return head;
    }
}
