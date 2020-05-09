package leecode.Tree;
/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 */
public class LowestCommonAncestor {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 算法:
     *  1. 从根节点开始遍历树
     *  2. 如果节点 p 和节点 q 都在右子树上，那么以右孩子为根节点继续 1 的操作
     *  3. 如果节点 p 和节点 q 都在左子树上，那么以左孩子为根节点继续 1 的操作
     *  4. 如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 p 和节点 q 的 LCA（最近公共祖先） 了
     *  * 因为二叉搜索树，所以最近公共祖先的大小一定是在 p和q之间的
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        int rootVal = root.val;
        if(pVal > rootVal && qVal > rootVal){
            return lowestCommonAncestor(root.right,p,q);
        }else if(pVal < rootVal && qVal < rootVal){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }
}
