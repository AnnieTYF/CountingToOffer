import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintBSTByDifferOrder {
    /**
     * 请实现一个函数按照之字形打印二叉树，
     * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 解法一：用两个栈，一个用来存奇数层的，一个用来存偶数层的
     * 奇数层先存右子树再存左子树，偶数层，先存左子树再存右子树，这样最后栈输出的时候就是之字形了
     * 也可以一个队列(奇)，一个栈（偶），都是先存左子树再存右子树，不过栈是倒序输出
     * 22ms
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<TreeNode> sOdd = new Stack<>();
        sOdd.push(pRoot);
        Stack<TreeNode> sEven = new Stack<>();
        int layer = 1;
        while(!sOdd.empty() || !sEven.empty()) {
            //奇数层
            if (layer % 2 != 0) {
                ArrayList<Integer> lay = new ArrayList<>();
                while (!sOdd.empty()) {
                    TreeNode node = sOdd.pop();
                    //这样就不用判断左右孩子是不是null了
                    if(node != null) {
                        lay.add(node.val);
                        //从左向右输出
                        sEven.push(node.left);
                        sEven.push(node.right);
                    }
                }
                if(!lay.isEmpty()) {
                    result.add(lay);
                    layer++;
                }
            } else {
                //偶数层
                ArrayList<Integer> lay = new ArrayList<>();
                while (!sEven.empty()) {
                    TreeNode node = sEven.pop();
                    if(node != null) {
                        lay.add(node.val);
                        //从右向左输出
                        sOdd.push(node.right);
                        sOdd.push(node.left);
                    }
                }
                if(!lay.isEmpty()) {
                    result.add(lay);
                    layer++;
                }
            }
        }
        return result;
    }
}
