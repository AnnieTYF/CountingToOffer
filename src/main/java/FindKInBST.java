import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class FindKInBST {
    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。
     * 例如，（5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4
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
     * 正规解法：二叉搜索树，左子树小于根节点，右子树大于根节点，中序遍历就是从小到大顺序遍历
     * 所以我们只需要找到中序遍历第K个值就行了
     * 35ms
     */
    public TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k == 0){
            return null;
        }
        int index = 0;
        Stack<TreeNode> s = new Stack<>();
        while(pRoot != null||!s.empty()){
            //先遍历左子树
             while(pRoot != null){
                 s.push(pRoot);
                 pRoot = pRoot.left;
             }
             pRoot = s.pop();
             index++;
             if(index == k){
                 return pRoot;
             }
             //再遍历右子树
             pRoot = pRoot.right;
        }
        return null;
    }

    /**
     * 解法二：中序遍历递归
     */
    int index = 0;
    TreeNode KthNode3(TreeNode pRoot, int k)
    {if(pRoot != null){
        TreeNode node = KthNode3(pRoot.left,k);
        /**
         * if(node!=null)说明已经找到第K小的节点
         *  如果没有if(node != null)这句话  那么那个pRoot就是返回给上一级的父结点的，而不是递归结束的条件
         *  若没有这句话，返回的值就是每一个节点的父节点，不是第K个值
         *  有了这句话过后，一旦返回了pRoot，那么node就不会为空了，就一直一层层的递归出去到结束
         *  例：{8,6,5,7,},1 答案是5
         * 如果不加的时候，开始，pRoot=8，node=kth（6,1），继续pRoot=6，node=kth（5,1）pRoot =5返回null，
         * 这时向下执行index=k=1了，返回5给root=6递归的时候的node，这时回到root=8了，往后面调右孩子的时候为空而把5给覆盖了
         */
        if(node != null) {
            return node;
        }
        index++;
        if(index == k){
            return pRoot;
        }
        node = KthNode3(pRoot.right,k);
        if(node != null) {
            return node;
        }
    }
        return null;
    }
}
