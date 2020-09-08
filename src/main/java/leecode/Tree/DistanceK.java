package leecode.Tree;

import java.util.*;

public class DistanceK {
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap<>();
        dfs(root,null);

        List<Integer> list=new LinkedList<Integer> ();
        if(root==null||target==null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        //用set保存访问状态比较方便
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);

        while (!queue.isEmpty() && K>0) {
            int size = queue.size();
            K--;
            while (size > 0) {
                TreeNode node = queue.poll();
                //搜索分三个方向，left和right是往左右两个子节点方向搜，map是往父节点方向搜，
                // 前面把所有节点跟父节点关联起来就是为了这个
                if (node.left != null && seen.add(node.left)) {
                    queue.add(node.left);//下一层搜索(左节点) + 标记该节点已访问
                }
                if (node.right != null && seen.add(node.right)) {
                    queue.add(node.right);
                }
                //向父节点方向搜索，有visitedSet记录访问状态，不会重复访问，当搜索到根节点时这一方向结束
                if (parent.containsKey(node) && seen.add(parent.get(node)))
                    queue.add(parent.get(node));
                size--;
            }
        }
        while(!queue.isEmpty()){
            list.add(queue.poll().val);
        }
        return list;
    }
    //深度遍历，对所有节点添加一个指向父节点的引用
    public void dfs(TreeNode node, TreeNode par) {
        if (par != null) {
            parent.put(node, par);
        }
        if(node.left!=null) {
            dfs(node.left, node);
        }
        if(node .right!=null) {
            dfs(node.right, node);
        }
    }
}
