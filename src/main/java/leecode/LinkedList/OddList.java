package leecode.LinkedList;

public class OddList {
    public class Node {
        int val;
        Node next;
        Node(int x) { val = x; }
    }
        /**
         * 按照奇偶位拆分成两个链表
         */
        public static Node[] getLists(Node head){
            Node head1 = null;
            Node head2 = null;

            Node cur1 = null;
            Node cur2 = null;
            int count = 1;//用来计数
            while(head != null){
                if(count % 2 == 1){
                    if(cur1 != null){
                        cur1.next = head;
                        cur1 = cur1.next;
                    }else{
                        cur1 = head;
                        head1 = cur1;
                    }
                }else{
                    if(cur2 != null){
                        cur2.next = head;
                        cur2 = cur2.next;
                    }else{
                        cur2 = head;
                        head2 = cur2;
                    }
                }
                head = head.next;
                count++;
            }
            //跳出循环，要让最后两个末尾元素的下一个都指向null
            cur1.next = null;
            cur2.next = null;

            Node[] nodes = new Node[]{head1, head2};
            return nodes;
        }

        /**
         * 反转链表
         */
        public static Node reverseList(Node head){
            Node pre = null;
            while(head != null){
               Node temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
            }
            return pre;
        }
        /**
         * 合并两个有序链表
         */
        public static Node combineList(Node head1, Node head2){
            if(head1 == null) {
                return head2;
            }
            if(head2 == null) {
                return head1;
            }
            if(head1.val < head2.val) {
                head1.next = combineList(head1.next, head2);
                return head1;
            } else {
                head2.next = combineList(head1, head2.next);
                return head2;
            }
        }
}
