package leecode.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSum2 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        retrace(root,sum);
        return res;
    }

    public void retrace(TreeNode node, int sum){
        if(node == null){
            return ;
        }
        path.addLast(node.val);
        sum -= node.val;
        if(sum == 0 && node.left == null && node.right == null){
            res.add(new ArrayList<>(path));
        }
        if(node.left != null){
            retrace(node.left,sum);
        }
        if(node.right != null){
            retrace(node.right,sum);
        }
        path.pollLast();
    }
}
