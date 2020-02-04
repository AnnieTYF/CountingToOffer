import java.util.Stack;

public class FirstCommonNodeList {
    /**
     * 输入两个链表，找出它们的第一个公共结点。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解法一：最简单的循环查找
     * O(N^2)
     * 25ms
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
         if(pHead1 == null || pHead2 == null){
             return null;
         }
         ListNode node1 = pHead1;
         ListNode node2 = pHead2;
         ListNode commonNode = null;
         while(node1 != null ){
             while(node2 != null){
                 if(node1 == node2){
                     commonNode = node1;
                     return commonNode;
                 }else{
                     node2 = node2.next;
                 }
             }
             node2 = pHead2;
             node1 = node1.next;
         }
         return commonNode;
    }
    /**
     * 解法二：其实这道题有个隐藏点，如果两个链表有共同节点，则从共同节点一直到链尾，两个链表都是一致的
     * 所以只需要找到两个链表中较小的比如说长度为a+n
     * 然后第二个链表从后往前数a+n个位置开始同时后移看是否有相等的节点
     * 具体实现：
     * 假定 List1长度: a+n  List2 长度:b+n, 且 a < b
     * 那么 p1 会先到链表尾部, 这时p2 走到 链表2的a+n位置,将p1换成List2头部
     * 接着p2 再走b+n-(n+a) =b-a 步到链表尾部,这时p1也走到List2的b-a位置，【这时，链表2剩下的长度为a+n】还差a步就到可能的第一个公共节点。
     * 将p2 换成 List1头部，p2走a步也到可能的第一个公共节点。如果恰好p1==p2,那么p1就是第一个公共节点。
     * 或者p1和p2一起走n步到达列表尾部，二者没有公共节点，退出循环。 同理a>=b.
     * O(a+b+n)
     * 22ms
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;

        while(node1 != node2 ){
            if(node1 != null)
                node1 = node1.next;
            if(node2 != null)
                node2 = node2.next;
            if(node1 != node2){
                if(node1 == null)
                    node1 = pHead2;
                if(node2 == null)
                    node2 = pHead1;
            }
        }
        return node1;
    }

    /**
     * 解法三：用栈，将两个链表放出栈中，同时出栈，则最后一个相同点是他们的共同点
     * 33ms
     */
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode commonListNode = null;

        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek() ) {
            stack2.pop();
            commonListNode = stack1.pop();;
        }
        return commonListNode;
    }
}
