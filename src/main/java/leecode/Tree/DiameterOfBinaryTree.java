package leecode.Tree;

import java.util.*;

public class DiameterOfBinaryTree {

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。
     * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
     * 这条路径可能穿过也可能不穿过根结点
     * 示例 :
     * 给定二叉树
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     * 其实就是求二叉树的路径数 - 1
     * 2 -》 1 （4）+ 1（5）
     * 4 -》0
     * 5 -》 0
     * 1 -》2（2） + 1（3）
     * 最大就是 3
     */
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
      ans = 1;
      depth(root);
      return ans-1;
    }
    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = depth(node.left);// 左儿子为根的子树的深度
        int right = depth(node.right);// 右儿子为根的子树的深度
        ans = Math.max(ans,left+right+1); //// 计算直径即L+R+1 并更新ans
        return Math.max(left,right)+1; // 返回该节点为根的子树的深度
    }
}
