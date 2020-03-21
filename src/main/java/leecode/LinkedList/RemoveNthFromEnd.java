package leecode.LinkedList;

public class RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 创建头节点，让指针从头节点开始
     * 要不然，如果这个链表中本身只有一个元素，那就没办法删除
     * 会抛出 nullPointerException
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p0 = new ListNode(0);
        p0.next = head;
        ListNode p1 = p0;
        ListNode p2 = p0;

//找到倒数第n-1个结点，这样它的下一个结点就是要删除的了，n-1.next = n-1.next.next，删除第n个结点
        for(int i = 0; i <= n;i++){
            p2 = p2.next;
        }

        while( p2 != null ){
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return p0.next;
    }
}
