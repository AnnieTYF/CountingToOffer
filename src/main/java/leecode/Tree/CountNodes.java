package leecode.Tree;

public class CountNodes {
    //递归从最后一层判断是否是完全二叉树
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftLevel = treeLevel(root.left);
        int rightLevel = treeLevel(root.right);
        /**
         * 如果根节点的左子树深度等于右子树深度，则说明左子树为满二叉树
         * 所以左子树的节点总数我们可以直接得到，是 2^left - 1，加上当前这个 root 节点，则正好是 2^left。
         * 再对右子树进行递归统计
         * 如何计算 2^left，最快的方法是移位计算，因为运算符的优先级问题
         */
        if(leftLevel == rightLevel){
            return countNodes(root.right) + (1<<leftLevel);
        }else{
            /*
            left != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。
            同理，右子树节点 +root 节点，总数为 2^right。再对左子树进行递归查找
             */
            return countNodes(root.left) + (1<<rightLevel);
        }
    }
    public int treeLevel(TreeNode node){
        if(node == null){
            return 0;
        }
        return treeLevel(node.left)+1;
    }
}
