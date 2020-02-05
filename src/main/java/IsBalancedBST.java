public class IsBalancedBST {
    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
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
     * 解法一：递归，一棵空树或它的任意节点的左右两个子树的高度差的绝对值均不超过1。
     * 所以这里用到了上一道题，求二叉树的左右子树的深度
     * 如果每个节点的左右子树的高度相差不超过1，按照定义，它就是一颗平衡二叉树。
     *
     * 自顶向下,对于每个节点，都计算一下左子树以及右子树的差的绝对值，即每个节点都判断一下。
     * 算法复杂度为O（N*2）
     *
     * 这种做法的缺点：在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销
     * 17ms
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        //空树是平衡二叉树
        if(root == null){
            return true;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int differ = left - right;
        if(differ >1 || differ <-1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) ;
    }
    private int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(1+TreeDepth(root.left),1+TreeDepth(root.right));
    }
    /**
     * 解法二：解法一的改进，后序遍历
     * 改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
     * 如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
     *
     * 算法复杂度O(N)
     * 20ms
     */
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution2(TreeNode root) {
        //空树是平衡二叉树
        if(root == null){
            return true;
        }
        TreeDepth2(root);
        return isBalanced;
    }
    private int TreeDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = TreeDepth2(root.left);
        int right = TreeDepth2(root.right);
        int differ = left - right;
        if(differ >1 || differ <-1){
           isBalanced = false;
        }
        return right > left ? right+1:left+1;
    }

}
