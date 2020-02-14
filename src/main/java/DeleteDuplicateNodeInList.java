public class DeleteDuplicateNodeInList {
    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解法一：设立头节点
     * 22ms
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null|| pHead.next==null){
            return pHead;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = pHead;
        //这一步也很重要，如果pre指向的不是新建的点话，1->1->1->2这种情况，第一个节点就不能被删除
        ListNode pre = tempHead;
         ListNode cur = tempHead.next;
         while(cur != null ){
           if(cur.next != null && cur.val == cur.next.val){
               //这一步很重要，找到最后的一个相同节点，1->2->3->3->4->4->5，这里cur指向最后一个3，pre指向2
               //因为可能有很多个重复的，不一定是只有两个一样的
               while(cur.next != null && cur.val == cur.next.val){
                   cur = cur.next;
               }
               pre.next = cur.next;
               cur = cur.next;
           }else{
               pre = pre.next;
               cur = cur.next;
           }
         }
         return tempHead.next;
    }
}
