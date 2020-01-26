public class MirrorTree {
    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
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
     * 递归
     * @param root
     */

        public void Mirror(TreeNode root) {
            if(root == null){
                return;
            }
            TreeNode temp;
            temp = root.right;
            root.right = root.left;
            root.left = temp;
            //知道为什么从上到下这样可以吗，
            // 因为左右子树两个节点交换，他们的左右孩子指针也跟着他们一起交换了，并不只是值的交换
            Mirror(root.right);
            Mirror(root.left);
        }
}
