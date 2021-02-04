package leecode.LinkedList;

import java.util.HashMap;
import java.util.Map;


public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList2(Node head) {
        if(head == null){
            return null;
        }
        //创建一个哈希表，key是原节点，value是新节点
        Map<Node,Node> map = new HashMap<>();
        Node p = head;
        while(p != null){
            map.put(p,new Node(p.val));
            p = p.next;
        }
        p = head;
        //遍历原链表，设置新节点的next和random
        //p是原节点，map.get(p)是对应的新节点，p.next是原节点的下一个,map.get(p.next)是原节点下一个对应的新节点
        while(p != null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //第一步，在每个原节点后面创建一个新节点
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        //第二步，设置新节点的随机节点
        p = head;
        while(p != null){
            if(p.random != null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        //第三步，将两个链表分离
        Node dummy = new Node(0);
        p = head;
        Node cur = dummy;
        while(p != null){
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }
        return dummy.next;
    }
}
