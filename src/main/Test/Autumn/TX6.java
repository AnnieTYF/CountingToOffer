package Autumn;

import java.util.Scanner;
import java.util.Stack;

public class TX6 {

    static class ListNode{
        private int value;
        private ListNode next;
        ListNode(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] array = new int[count];
        for(int i = 0; i< count; i++){
            array[i] = in.nextInt();
        }
        input(array);

    }
    public static void input(int[] nums){
        int len = nums.length;
        ListNode head = new ListNode(nums[0]);
        ListNode p1 = head;

        for(int i = 1; i< len ; i++){
            ListNode node = new ListNode(nums[i]);
            p1.next = node;
            p1 = p1.next;
        }
        System.out.println(solution(head));
    }
    //栈中
    public static boolean solution(ListNode head){
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode fast = head;
        // 找到中间节点
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            p2 = p2.next;
        }
        //链表的右部分,放到栈中
      //  ListNode right = p2.next; 这行代码错了
        ListNode right = p2; //应该是这样
        while(right != null){
            stack.push(right);
            right = right.next;
        }
        //将栈中的元素和链表左部分值作比较
        while(!stack.isEmpty()){
            ListNode temp = stack.pop();
            if(p1.value != temp.value){
                return false;
            }
            p1 = p1.next;
        }
        return true;
    }
}
