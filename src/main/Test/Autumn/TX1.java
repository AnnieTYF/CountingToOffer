package Autumn;

import leecode.Tree.MinimumDepthOfBT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TX1 {
    public static class TreeNode {
        int val;
        TreeNode next;
        TreeNode(int x) { val = x; }
    }
    public static TreeNode head;
    public static TreeNode cur;
    public static void add(int data){
        if(head == null){
            head = new TreeNode(data);
        }else{
            cur.next = new TreeNode(data);
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        for(int i = 0; i< n ; i++){
            int num = in.nextInt();
            add(num);
        }
        System.out.println(remove(head,k));
    }

    public static TreeNode remove(TreeNode head, int k){
        TreeNode p0 = new TreeNode(0);
        p0.next = head;
        TreeNode p1 = p0;
        TreeNode p2 = p0;
        for(int i = 0; i<k ; i++){
            p2 = p2.next;
        }
        while(p2 != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return p0.next;
    }
}
