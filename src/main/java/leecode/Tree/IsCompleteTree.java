package leecode.Tree;

import java.util.LinkedList;

public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode pre = root;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size ; i++){
                TreeNode cur = queue.poll();
                //如果左子树为null，右子树不为null
                if(pre == null && cur != null){
                    return false;
                }
                if(cur != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
                pre = cur;
            }
        }
        return true;
    }
}
