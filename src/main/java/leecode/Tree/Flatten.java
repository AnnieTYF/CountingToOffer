package leecode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Flatten {

    /**
     * 给定一个二叉树，原地将它展开为一个单链表
     * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
     * 前序遍历的层次遍历
     * 链表的原地重排序
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root,list);
        for(int i = 1; i<list.size() ; i++){
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }

    }
    public void preorderTraversal(TreeNode root, List<TreeNode> list){
        if(root != null){
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }


        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollLast();
                output.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
            return output;
        }

}
