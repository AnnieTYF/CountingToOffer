public class MergeLinkedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode head = new ListNode(-1);
        head.next = null;
        //保存头节点
        ListNode p = head;
        while(list1!= null && list2!= null){
            if(list1.val < list2.val){
                /*
                每次head都是指向最后一个地址的。
                第一个是把list1“推”进head，但这个时候head是指向list1的前一个地址，
                需要更新head，指向最后一个地址。
                 */
                head.next = list1;
                head = list1;
                list1 = list1.next;
            }else{
                head.next = list2;
                head = list2;
                list2 = list2.next;
            }
        }

        if(list1 != null){

            head.next = list1;

        }
        if(list2 != null){

            head.next = list2;

        }
        return p.next;
    }
}
