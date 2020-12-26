package leecode.LinkedList;

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null;
        ListNode evenHead = null;

        ListNode oddCur = null;
        ListNode evenCur = null;

        int count = 1;
        while(head != null){
            if(count % 2 == 1){
                if(oddCur != null){
                    oddCur.next = head;
                    oddCur = oddCur.next;
                }else{
                    oddCur = head;
                    oddHead = oddCur;
                }
            }else{
                if(evenCur != null){
                    evenCur.next = head;
                    evenCur = evenCur.next;
                }else{
                    evenCur = head;
                    evenHead = oddCur;
                }
            }
            head = head.next;
            count++;
        }
        if(oddCur != null){
            oddCur.next = evenHead;
        }
        return oddHead;
    }
}
