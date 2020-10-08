package leecode.LinkedList;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        //构建小顶堆
        PriorityQueue<ListNode> pq =
                new PriorityQueue<>(lists.length,(a,b)->(a.val-b.val));
        for(ListNode node : lists){
            if(node == null){
                continue;
            }
            pq.add(node);
        }
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            temp.next = cur;
            temp = temp.next;
            //将该链表的下一个节点插入进行排序
            if(cur.next != null){
                pq.add(cur.next);
            }
        }
        return dummyHead.next;
    }
}
