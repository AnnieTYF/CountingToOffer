package leecode.LinkedList;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
            }else{
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = head2.next;
        cur2.next = null;
        return head1.next;
    }
}
