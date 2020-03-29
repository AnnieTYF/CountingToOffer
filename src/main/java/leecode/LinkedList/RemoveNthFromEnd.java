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
     * 官方，我们将添加一个哑结点作为辅助，该结点位于列表头部。
     * 哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部
     * 时间复杂度 O(N)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //哑结点
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
