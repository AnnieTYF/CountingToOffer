package leecode.Tree;

import leecode.LinkedList.ListNode;

public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        //边界条件的判断
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        //找到链表中间，奇数的时候中间数在前半部分
        while(fast != null && fast.next != null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        //链表断开为两部分,中间结点前面的就是根节点左子树的所有节点，中间节点后面的就是根节点右子树的所有节点
        //slow 为中间节点，所以我们要记录slow即中间节点前的节点，为左子树的区间
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        //从head节点到pre节点是root左子树的节点
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

}
