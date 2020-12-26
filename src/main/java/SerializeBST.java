public class SerializeBST {
    /**
     *请实现两个函数，分别用来序列化和反序列化二叉树
     * 二叉树的序列化是指：
     * 把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
     * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
     * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
     * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
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
     * 前序遍历，遇到叶子节点就在后面加 ‘#’
     *      5
     *    / \
     *   3   7
     *  / \ / \
     * 2  4 6  8
     * {5，3，2，#，4，#，7，6，#，8，#}
     */
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serializeHelp(root,str);
        return str.toString();
    }
    public void serializeHelp(TreeNode root,StringBuilder str){
        if(root == null){
            //注意井号后面也要加逗号
            str.append("#,");
            return;
        }
        str.append(root.val + ",");
        serializeHelp(root.left,str);
        serializeHelp(root.right,str);
    }
    /**
     * 得到的是前序遍历顺序得字符串
     * {5，3，2，#，4，#，7，6，#，8，#}
     * 36ms
     * @param str
     * @return
     */
    public TreeNode deserialize(String str) {
        String[] strings = str.split(",");
        return deserializeHelp(strings);
    }
    private int index=-1;
    public TreeNode deserializeHelp(String[] strings){
        index++;
        String first = strings[index];
        if(first.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserializeHelp(strings);
        root.right = deserializeHelp(strings);
        return root;
    }
}
