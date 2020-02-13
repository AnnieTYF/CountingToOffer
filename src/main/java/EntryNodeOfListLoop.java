import java.util.HashSet;

public class EntryNodeOfListLoop {
    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 这个是真的不会，看其他大佬的思路
     * 解法一：使用set
     * 将所有链表的结点都加入set中，如果有重复的那那个就是环的入口
     * 17ms
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        HashSet<ListNode> set = new HashSet<>();
        while(pHead != null) {
            if (!set.add(pHead)) {
                return pHead;
            }
            pHead = pHead.next;
        }
        return null;
    }

    /**
     * 解法二：两指针快慢法，快指针每次跳两个，慢指针每次跳一个，快慢指针一定会在环中的某节点相遇
     * Q1:如何判断有环？
     * 1. 如果快指针走到null，说明没有环
     * 2. 如果快慢指针相遇，说明有环
     * Q2:找入口
     * 如果slow 走了L的长度。那么fast = 2L，设环外长度为s,slow在环内走了d ，L = s+d
     * 假设环内剩余的长度为m，则 2L = s+(d+m)*n+d ,fast走了n圈
     * 两式相减得 (d+m)*n = s+d
     * s = (d+m)*n  - d = n*m + (n-1)*d = m + (n-1)(m+d)
     * ->结论：从头节点到环入口的距离 = 两指针相遇到换入口的距离
     * 17ms
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        //判断有环
        while(fast != null && fast.next!= null){
             fast = fast.next.next;
             slow = slow.next;
             if(fast == slow){
                 break;
             }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        //找到环的入口,从头节点到环入口的距离 = 两指针相遇到换入口的距离
        //当然也可以不建立新的结点，让fast = phead，只是个人觉得这样好理解
        ListNode newNode = pHead;
        while(newNode != slow){
             newNode = newNode.next;
             slow = slow.next;
        }
        return slow;
    }

}
