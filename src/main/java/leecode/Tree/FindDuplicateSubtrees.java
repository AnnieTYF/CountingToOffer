package leecode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindDuplicateSubtrees {
    /**
     * 前序遍历，找到所有的子树
     * 没找到一个子树，都将子树序列化成数组存在集合中，判断是否重复，重复就返回第一个节点
     */
    //序列化子树
    List<TreeNode> res = new ArrayList<>();
    HashMap<String,Integer> memo = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preOrder(root);
        return res;
    }
    public String preOrder(TreeNode root){
        if(root == null){
            return "#"; // 对于空节点，可以用一个特殊字符表示
        }
        String left = preOrder(root.left);
        String right = preOrder(root.right);
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = left+","+right+","+root.val;
        int seq = memo.getOrDefault(subTree, 0);
        if(seq == 1){
            res.add(root);// 多次重复也只会被加入结果集一次
        }
        memo.put(subTree,seq+1);// 给子树对应的出现次数加一
        return subTree;
    }
}
