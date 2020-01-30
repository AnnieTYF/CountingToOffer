import java.util.Stack;

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

    /**
     * 非递归解法,栈，当然也可以用队列实现
     */
    public void Mirror2(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            TreeNode temp;
            temp = node.right;
            node.right = node.left;
            node.left = temp;
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
    }
}
