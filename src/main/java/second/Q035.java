package second;

/**
 * 035. 复杂链表的复制
 */
public class Q035 {
    public Node copyRandomList(Node head) {

        // 扩展链表
        Node p = head;
        while(p != null){
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }

        // 完善random指针
        p = head;
        while(p != null && p.next != null){
            if(p.random == null){
                p.next.random = null;
            }else{
                p.next.random = p.random.next;
            }
        }

        // 拆分链表
        // p为旧链表，newHead为新链表
        p = head;
        Node dummy = new Node(-1);
        Node newHead = p.next;
        dummy.next = newHead;
        while(p != null && newHead != null){
            p.next = newHead.next;
            p = p.next;
            newHead.next = p.next;
            newHead = newHead.next;
        }

        return dummy.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
