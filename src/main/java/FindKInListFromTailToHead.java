
public class FindKInListFromTailToHead {

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    int count = 1;
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode node = null;
        if( head != null){
            this.FindKthToTail(head.next, k);
            if(count == k){
                node = head;
                count++;
            }else{
                count++;
            }
        }
        return node;
    }

    /**
     * 解法一：设置两个节点P1,P2，P2先走k-1个，然后P1,P2一起走，知道P2为null
     * 此时p1就是倒数第k个节点
     * 相当于制造了一个K长度的尺子，把尺子从头往后移动，
     * 当尺子的右端与链表的末尾对齐的时候，尺子左端所在的结点就是倒数第k个结点
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail1(ListNode head,int k) {
        //算法为空，或者k<=0，输出为null
        if(head == null || k<=0){
            return null;
        }
        ListNode p2 = head;
        ListNode p1 = head;
        while(k>1){
            if(p2.next != null){
                p2 = p2.next;
                k--;
            }else{
                //当k大于链表长度则返回 空，否则的话继续走
                return null;
            }
        }
        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    /**
     * 解法一的优化，看看人家写的代码
     */
    public ListNode FindKthToTail11(ListNode head,int k) {
        //算法为空，或者k<=0，输出为null
        if(head == null || k<=0){
            return null;
        }
        ListNode p2,p1;
         p1 = p2= head;
         int i = 0;
         for(;p2!=null;i++){
            if(i >= k){
                p1 = p1.next;
            }
            p2 = p2.next;
         }
        //k大于链表长度则返回 空
        return i<k ? null:p1;
    }


}
