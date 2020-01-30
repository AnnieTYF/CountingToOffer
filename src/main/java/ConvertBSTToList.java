import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class ConvertBSTToList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 解法一：中序遍历
     * 注意是双向链表，所以要注意链表的双向指的是什么
     * 链表的右指针指向下一个节点，做指针指向上一个节点
     * 这个和二叉树指向左右子树是不一样的
     */
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return pRootOfTree;
        }
        Convert(pRootOfTree.left);
        if(head == null){
            head = pRootOfTree;
            //保存头节点
            realHead = pRootOfTree;
        }else{
            //指向下一个节点，比如说4.right->6
            head.right = pRootOfTree;
            //上一个节点，6.left->4
            pRootOfTree.left = head;
            //节点指针向后移动，4 = 6
            head = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return realHead ;
    }

    /**
     * 解法二：中序遍历，的倒序
     * 这样从尾节点向前遍历，最后返回的指针就是头指针
     */
    TreeNode tail = null;
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return pRootOfTree;
        }
        Convert(pRootOfTree.right);
        if(tail== null){
            tail = pRootOfTree;
        }else{
            //指向上一个节点，6.left->4
            tail.left = pRootOfTree;
            //下一个节点，4.right -> 6
            pRootOfTree.right = tail;
            //节点指针向前移动，6= 4
            tail = pRootOfTree;
        }
        Convert(pRootOfTree.left);
        return tail ;
    }

    /**
     * 解法三：非递归实现，利用栈实现。也是倒序，这样就不用再设置一个节点保存头节点了
     * 这个逻辑有点绕，可以画图验证
     */
    public TreeNode Convert3(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return pRootOfTree;
        }
        TreeNode head = null;
        Stack<TreeNode> stack = new Stack<>();
        while(pRootOfTree != null || !stack.isEmpty()){
            if(pRootOfTree != null){
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.right;
            }else{
                pRootOfTree = stack.pop();
               if(head == null){
                   head = pRootOfTree;
               }else{
                   head.left = pRootOfTree;
                   pRootOfTree.right = head;
                   head = pRootOfTree;
               }
               pRootOfTree = pRootOfTree.left;
            }
        }
        return head ;
    }


}
