package second;

import com.domain.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q143 {

    ListNode list;
    boolean flag = true;
    public void reorderList(ListNode head) {
        list = head;
        ListNode p = head;
        dfs(p);
    }

    public void dfs(ListNode head){
        if(head == null){
            return;
        }
        dfs(head.next);

        if(!flag){
            // 特别注意这里
            return;
        }
        if(list == head || list.next == head){
            head.next = null;
            flag = false;
            return;
        }

        ListNode temp = list.next;
        list.next = head;
        head.next = temp;
        list = temp;
    }

    @Test
    public void t(){
        int max = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        System.out.println(max);
        System.out.println(min);
        System.out.println(max != min);
        List<Integer> list = new ArrayList<>();
        list.add(max);
        list.get(0).intValue();
    }
}
