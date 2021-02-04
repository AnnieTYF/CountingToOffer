package leecode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTIterator {
   /* Queue<Integer> queue = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        TreeNode cur = temp.pollLast();
        while(cur != null || !temp.isEmpty()){
            //将左节点全部放入队列中
            while(cur != null){
                temp.offer(cur);
                cur = cur.left;
            }
            cur = temp.pollLast();
            if(cur != null){
                queue.offer(cur.val);
            }
            cur = cur.right;
        }
    }

    *//** @return the next smallest number *//*
    public int next() {
        return queue.poll();
    }*/

 /*   *//** @return whether we have a next smallest number *//*
    public boolean hasNext() {
        return !queue.isEmpty();
    }*/
    //受控递归，将迭代实现的中序遍历拆分成函数
   Stack<TreeNode> stack ;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        leftmostInorder(root.left);
    }

    private void leftmostInorder(TreeNode root) {
        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        if(temp.right != null){
            leftmostInorder(temp.right);
        }
        return temp.val;
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
