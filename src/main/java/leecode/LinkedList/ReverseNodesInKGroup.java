package leecode.LinkedList;

/**
 * k个一组反转链表
 */
public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a,b;
        a =  head;
        b = head;
        for(int i = 0; i<k; i++){
            if(b == null){
                return head;
            }
            b = b.next;
        }
        //反转[a,b)区间的链表
        ListNode newHead = reverse(a,b);
        //将上一个反转的结尾和下一轮反转的开头相连
        a.next = reverseKGroup(b,k);
        return newHead;
    }
    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    public ListNode reverse(ListNode a, ListNode b){
        ListNode pre, cur, temp;
        pre = null;
        cur = a;
        while(cur != b){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
