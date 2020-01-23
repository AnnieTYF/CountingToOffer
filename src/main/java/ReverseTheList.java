public class ReverseTheList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解法一：
     * 1. 定义两个节点：pre, cur ，其中 cur 是 pre 的后继结点，
     * 如果是首次定义， 需要把 pre 指向 cur 的指针去掉，否则由于之后链表翻转，cur 会指向 pre， 就进行了一个环
     * 2.知道了 cur 和 pre,翻转就容易了，
     * 把 cur 指向 pre 即可，之后把 cur 设置为 pre ，cur 的后继结点设置为 cur 一直往前重复此步骤即可
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre,cur;
        pre = head;
        cur = pre.next;
        //pre是第一个节点，避免形成环
        pre.next = null;
        while(cur != null){
            //在 cur 指向 pre 之前一定要先保留 cur 的后继结点
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        //因为这道题中没有头节点，所以不需要head.next = pre
        return pre;
    }

    /**
     * 解法二：递归
     * @param head
     * @return
     */
    public ListNode ReverseList2(ListNode head) {
        //如果链表为空
        if(head == null ){
            return head;
        }
        //递归一定要加这个判断，如果链表中只有一个元素
        if(head.next == null){
            return head;
        }
        //先反转后面的链表，走到链表的末端结点
        ListNode newNode = ReverseList(head.next);
        //再将当前节点设置为后面节点的后续节点
        head.next.next = head;
        head.next = null;
        return  newNode;
    }

}
