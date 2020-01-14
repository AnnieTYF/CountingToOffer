import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintListFromTailToHead {
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    private ListNode head;

    /**
     * 我不是很会java中的链表，不知道该怎么在main函数中创建一个
     * @param args
     */
   public  void add(String args[]){
        List list = Arrays.asList("67","0","24","58");
        for(int i = 0; i< list.size();i++){
           ListNode listNode = new ListNode((int)list.get(i));
           if(head == null){
               head = listNode;
               return;
           }
            ListNode  tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = listNode;
        }
        System.out.println(printListFromTailToHead(head));
    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 利用了递归和栈，递归本身也可以实现栈的效果，先进后出
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }


}
