/**
 * 链表中的结点，data代表节点的值，next是指向下一个节点的引用
 */
class Node {
    int data;// 结点的数组域，值
    Node next = null;// 节点的引用，指向下一个节点
    public Node(int data) {
        this.data = data;
    }
}
public class LinkedList {
    int length = 0; // 链表长度，非必须，可不加
    Node head = new Node(0); // 哨兵节点

    public void addNode(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp.next = tmp;
            }
            tmp.next = new Node(val);
        }
    }


    /**
     * 递归翻转结点 node 开始的链表
     */
    public Node invertLinkedList(Node node) {
        if (node.next == null) {
            return node;
        }

        // 步骤 1: 先翻转 node 之后的链表
        Node newHead = invertLinkedList(node.next);

        // 步骤 2: 再把原 node 节点后继结点的后继结点指向 node，node 的后继节点设置为空(防止形成环)
        node.next.next = node;
        node.next = null;

        // 步骤 3: 返回翻转后的头结点
        return newHead;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        int[] arr = {4,3,2,1};
        for (int i = 0; i < arr.length; i++) {
            linkedList.addNode(arr[i]);
        }
        Node newHead = linkedList.invertLinkedList(linkedList.head.next);
        // 翻转后别忘了设置头结点的后继结点！
        linkedList.head.next = newHead;
        // linkedList.printList();      // 打印 1，2，3，4
    }
}


