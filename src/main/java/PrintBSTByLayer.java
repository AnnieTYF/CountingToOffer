import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintBSTByLayer {
    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
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
     *解法一：非递归
     * 我觉得只要涉及到分层，都需要两个容器
     * 比如说这道题，两个队列交叉打印，好处就是不必再判断一层有多少个节点
     * 25ms
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> s1 = new LinkedList<>();
        s1.offer(pRoot);
        Queue<TreeNode> s2 = new LinkedList<>();
        int layer = 1;
        while(!s1.isEmpty() || !s2.isEmpty()){
            //奇数层
            if(layer%2 != 0){
                ArrayList<Integer> temp = new ArrayList<>();
                while(!s1.isEmpty()){
                    TreeNode node = s1.poll();
                    if(node != null){
                        s2.offer(node.left);
                        s2.offer(node.right);
                        temp.add(node.val);
                    }
                }
                if(!temp.isEmpty()){
                    result.add(temp);
                    layer++;
                }
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                while(!s2.isEmpty()){
                    TreeNode node = s2.poll();
                    if(node != null){
                        s1.offer(node.left);
                        s1.offer(node.right);
                        temp.add(node.val);
                    }
                }
                if(!temp.isEmpty()){
                    result.add(temp);
                    layer++;
                }
            }
        }
        return result;
    }
    /**
     * 解法二：非递归
     * 队列加上两个状态：还要打印的个数和下一行的结点个数。当队列空的时候停止循环
     * 31ms
     */
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        //存放结果
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList();
        if (pRoot == null) {
            return arrayLists;
        }
        //使用队列，先进先出
        Queue<TreeNode> queue = new LinkedList();
        //存放每行的列表
        ArrayList arrayList = new ArrayList();
        //记录本层打印了多少个
        int start = 0;
        //记录本层一共要打印多少个节点
        int end = 1;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            //添加到本行的arrayList
            arrayList.add(temp.val);
            start++;
            //每打印一个节点，就把此节点的下一层的左右节点加入队列，并记录下一层要打印的个数
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            //判断本层打印是否完成
            if (start == end) {
                //此时的queue中存储的都是下一层的节点，则end即为queue大小
                end = queue.size();
                start = 0;
                //把arrayList添加到结果列表arrayLists中
                arrayLists.add(arrayList);
                //重置arrayList
                arrayList = new ArrayList();
            }
        }
        return arrayLists;
    }

    /**
     * 解法三：递归，这道题最关键的点在于如何保存层数信息
     * 递归和非递归都可以用下面的方法，区别在于非递归中deep可以用map保存(HashMap<TreeNode, Integer> map) ，递归中deep作为参数
     * 用变量 deep 存储层数信息，子树的 deep+1，该 deep 可以作为 Lists （作为结果的那个arrayList）的索引
     * 当 deep >= lists 的大小，说明该层还未被存入过 lists，建立新的 list，存结点值，再把 list 存入 lists
     * 当 deep < lists 的大小，说明该层已经被存储过，取出原来存在 lists 中的该层 list，把结点信息继续存入 list
     * 27ms
     */
    public ArrayList<ArrayList<Integer> > Print3(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        //这里的代码写的太精简了，反而让人不好理解
        /**
         * 不断地扩容，最后答案类似这样{{1}，{2，3},{4,5,6}}
         * 利用递归的方法进行先序遍历，传递深度，递归深入一层扩容一层数组，先序遍历又保证了同层节点按从左到右入数组
         * 如果depth大于当前层，需要新建一个arrayList
         * 如果depth == 当前层，就在之前建立的arrayList的基础上，添加数据
         */
        if(depth > list.size())
            list.add(new ArrayList<Integer>());
        //获取该层的arrayList，并向之中添加数据
        /**
         * 这句话的本质上是这样的
         *  ArrayList<Integer> temp = list.get(depth -1);
         *  temp.add(root.val);
         */
        list.get(depth -1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }




    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        PrintBSTByLayer printBSTByLayer = new PrintBSTByLayer();
        TreeNode treeNode = printBSTByLayer.createBinaryTreeByArray(array, 0);
        for (ArrayList list :
                printBSTByLayer.Print2(treeNode)) {
            System.out.println(list);
        }
    }
    //创建二叉树的方法
    private TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }



}
