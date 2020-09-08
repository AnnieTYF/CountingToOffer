package leecode.Tree;

public class minDiffInBST {
     /**
      * 在二叉搜索树中，中序遍历会将树中节点按数值大小顺序输出。
      * 只需要遍历计算相邻数的差值，取其中最小的就可以了
      */
     Integer preVal;
     Integer ans;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(preVal != null){
            ans = Math.min(ans,node.val-preVal);
        }
        preVal = node.val;
        dfs(node.right);
    }
}
