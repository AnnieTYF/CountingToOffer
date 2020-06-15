package leecode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 */
public class MinimumDepthOfBT {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1; // 因为根节点已经是第一层了，所以从1开始

        while(!queue.isEmpty()){
            //每次要重新计算当前队列的长度
            int size = queue.size();
            for(int i = 0; i< size;i++){
                //取出第一个并删除
                TreeNode node = queue.poll();
                /* 判断是否到达终点 */
                if(node.left == null && node.right == null){
                    return depth;
                }
                /* 将 node 的相邻节点加入队列 */
                if(node.left != null){
                        queue.offer(node.left);
                }
                if(node.right != null){
                        queue.offer(node.right);
                }
            }
            /* 这里增加深度 */
            depth++;
        }
        return depth;
    }
}
