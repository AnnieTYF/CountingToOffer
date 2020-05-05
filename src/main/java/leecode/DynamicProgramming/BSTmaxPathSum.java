package leecode.DynamicProgramming;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */

public class BSTmaxPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int masSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
          return masSum;
    }
    public int dfs(TreeNode node) {
        if(node == null){
            return 0;
        }
        //如果dfs是负值的话，就取0，不增加
        int left = Math.max(dfs(node.left),0);
        int right = Math.max(dfs(node.right),0);
        //最大路径和其实是最大子树和
        int newPath = node.val + left + right;
        //最大值为左右路径的max
        masSum = Math.max(newPath,masSum);
        //自底向上，子路径最大值与当前结点的值组成新的路径值
        return node.val + Math.max(left,right);
    }
}
