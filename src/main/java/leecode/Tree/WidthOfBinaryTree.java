package leecode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        while(queue.size()>0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            //如果节点的左/右子树不为空，也放入队列中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                int curIndex = list.removeFirst();
                if(t.left!=null) {
                    queue.add(t.left);
                    list.add(curIndex * 2);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                    list.add(curIndex * 2 + 1);
                }
            }
            if(list.size() >= 2){
                res = Math.max(res,list.getLast()-list.getFirst()+1);
            }
        }
        return res;
    }

}
