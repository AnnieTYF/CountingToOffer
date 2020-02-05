import java.util.*;

public class BinaryTreeDepth {
    /**
     * 输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
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
     * 24ms
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(1+TreeDepth(root.left),1+TreeDepth(root.right));
    }
    /**
     * 解法二：非递归，队列
     * 21ms
     */
    public int TreeDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0,nextCount = 1,depth = 0;
        while(queue.size() != 0){
            TreeNode temp = queue.poll();
            count ++;
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
            /*
            depth：当前节点所在的层数，
            count已经遍历了的节点数，
            nextCount下层的节点总数；
            当count==nextCount的时候，代表本层的节点已经遍历完毕。
             */
            if(count == nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }
}
