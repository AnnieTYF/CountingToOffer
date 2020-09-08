package leecode.LinkedList;

/**
 * 请判断一个链表是否为回文链表。
 * 输入: 1->2->2->1
 * 输出: true
 * 输入: 1->2
 * 输出: false
 */
public class IsPalindrome {
    /**
     * 不用额外地址空间
     * 总结：我在做题的时候太慌了，实际上，不可能每道题你都遇见过
     * 所以先冷静思考，列出步骤，然后再开始写代码，你要相信自己的基本判断能力
     * 认定一个算法就不要中间轻易换，相信你的直觉
     * 但是如果面试的时候刚好碰到你遇到过的，不要犹豫，直接写
     * 1. 找出链表前半部分（可以用快慢指针）
     * 2. 后半部分反转
     * 3. 两边判断
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        //找到链表中间，奇数的时候中间数在前半部分
        while(fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //将链表后半部分反转,这里太容易错了 temp就等于 slow 不要 slow.next
        //因为上面循环的时候 slow已经是 slow = slow.next了
        ListNode temp = slow;
        ListNode last = reverse(temp);
        while(last != null){
            if(head.val != last.val){
                return false;
            }else{
                head = head.next;
                last = last.next;
            }
        }
        return true;
    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
