import java.util.LinkedList;
import java.util.Queue;

public class isSymmetricalBST {
    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
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
     * 解法一：递归
     * （设二叉树左子树为p，右子树为q，p、q均指向左右子树的根）
     * p和q的值相等，并且p的左子树与q的右子树对称，p的右子树与q的左子树对称
     * 左子树的左子树和右子树的右子树相同， 左子树的右子树和右子树的左子树相同
     *      1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 26ms
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        boolean isSymmetrical ;
        if(pRoot == null){
            return true;
        }
       return subTree(pRoot.left,pRoot.right);
    }
    private boolean subTree(TreeNode p,TreeNode q){
        if(p == null && q==null){
            return true;
        }
        if(p == null  || q == null){
           return false;
        }
        if(p.val == q.val){
            return subTree(p.left,q.right) && subTree(p.right,q.left);
        }
            return false;
    }
    /**
     * 解法二：非递归，BFS使用队列
     * 注意入队的顺序 p.left,q.right | p.right,q.left
     * 成对的入队，出队
     * java中，LinkedList继承了Queue接口
     * 18ms
     */
    boolean isSymmetrical2(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if(p == null && q==null){
               continue;
            }
            if(p == null  || q == null){
                return false;
            }
             if(p.val != q.val){
                return false;
             }
             queue.offer(p.left);
             queue.offer(q.right);
             queue.offer(p.right);
             queue.offer(q.left);
        }
        return true;
    }
}
