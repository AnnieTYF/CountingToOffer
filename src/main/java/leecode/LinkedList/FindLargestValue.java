package leecode.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 在二叉树的每一行中找到最大的值
 */
public class FindLargestValue {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while(queue.size()>0) {
            int max = Integer.MIN_VALUE;
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                max = Math.max(max,t.val);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
