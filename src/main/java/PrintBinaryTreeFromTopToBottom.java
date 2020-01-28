import java.util.ArrayList;

public class PrintBinaryTreeFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 解法一：常规递归
     */
    ArrayList<Integer> array = new ArrayList<Integer>();
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null){
            return array;
        }
        //先添加头节点
        array.add(root.val);
        PrintTree(root);
        return array;
    }
    private  ArrayList<Integer> PrintTree(TreeNode node){
        //叶子节点
        if(node.left == null && node.right == null){
            return array;
        }
        //节点的左子树为空
        if(node.left == null ){
            array.add(node.right.val);
            PrintTree(node.right);
            return array;
        }else if(node.right == null){
            //节点的右节点为空
            array.add(node.left.val);
            PrintTree(node.left);
            return array;
        }
        array.add(node.left.val);
        array.add(node.right.val);
        PrintTree(node.left);
        PrintTree(node.right);
        return array;
    }

    /**
     * 解法二：用arrayList模拟队列,实现二叉树的遍历
     */
    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer>  list = new ArrayList<>();
        //保存节点的队列
        ArrayList<TreeNode>  queue = new ArrayList<>();
        if(root == null){
            return list;
        }
        queue.add(root);
        while(queue.size() > 0){
            TreeNode temp = queue.remove(0);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }
}
