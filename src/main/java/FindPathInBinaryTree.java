import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class FindPathInBinaryTree {
    /**
     * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 解题思路：深度遍历，我觉得特别巧的是，用的不是相加相等，而是相减为0
     * 这里没有排序
     * @param root
     * @param target
     * @return
     */
    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return result;
        }
        path.add(root.val);
        /*有可能有疑问，为什么最后回退的时候，target值不需要重新设为开始值
          变量是作为方法参数往下传的，target是int型，在方法内部赋予新值不会影响方法外该变量的值。
          值传递，都是函数栈中的局部变量，返回上一个函数栈时，
          上一个函数栈中的target是一个没减之前的。所以加不加是没有任何影响的
         */
        target = target - root.val;
       if(target == 0 && root.left == null && root.right == null){
           //因为add添加的是引用，如果不new一个的话，后面的操作会更改这个path
           //不重新new的话从始至终result中所有引用都指向了同一个一个path
           result.add(new ArrayList<Integer>(path));
       }
        FindPath(root.left,target);
        FindPath(root.right,target);
        //移除最后一个元素，深度遍历完一条路径后要回退
        //递归到叶子节点时，要回退到父节点继续遍历
        path.remove(path.size()-1);
        return result;
    }


    /**
     * 解法二：加了一个collection排序
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> cur=new ArrayList<>();

        helper(root,target,cur,res);
        //这里可以用lambda简化一下代码，不过这样好像运行时间会增加，挺多的
        //Collections.sort(res, (o1,o2)->o2.size()-o1.size());
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size()<o2.size()){
                    return 1;
                }else return -1;
            }
        });
        return res;
    }
    public void helper(TreeNode root,int target,ArrayList<Integer> cur,ArrayList<ArrayList<Integer>> res){
        if (root==null) return;
        int value=root.val;
        cur.add(value);
        if (target==value&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(cur));
        }else {
            helper(root.left,target-value,cur,res);
            helper(root.right,target-value,cur,res);
        }

        cur.remove(cur.size()-1);
    }
}
