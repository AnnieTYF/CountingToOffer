package leecode.String;

/**
 * 前缀树
 */

/**
 * 定义前缀树结构
 * 建立一个26大小的数组，每个数组存储一个TreeNode结构
 * 每个结点所在的位置就是对应字符的ASCII码值
 * 每个结点，有一个标志元素isEnd，判断这个字符是否是某一个字符串的结束位
 * 查找的时候，就将字符串中的字符挨个在数组中遍历，如果字符串最后一个字符在数组中的isEnd为True
 * 说明，这个字符串在前缀树中
 * 【我觉得我在哪里见过这个思路】
 */
class  TreeNode{
    // R links to node children,最多 R个指向子结点的链接，其中每个链接对应字母表数据集中的一个字母。
    //总的树TreeNode[]
    private TreeNode[] links;
    //本题中假定 R 为 26，小写拉丁字母的数量
    private final int R = 26;
    //布尔字段，以指定节点是对应键的结尾还是只是键前缀
    private boolean isEnd;

    public TreeNode(){
        links = new TreeNode[R];
    }

    public boolean containKey(char ch){
        return links[ch - 'a'] != null;
    }

    public TreeNode get(char ch){
        return links[ch-'a'];
    }
    //创建一个新的树的子节点，TreeNode[]的TreeNode
    public void put(char ch, TreeNode node){
        links[ch-'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}
public class Trie {
    private TreeNode root;
   //前缀树的方法类，也要有构造器，构造器就是构造一个新的结点为根节点
    public Trie(){
        root = new TreeNode();
    }

    /**
     * 向 Trie 树中插入键：
     * 我们通过搜索 Trie 树来插入一个键。我们从根开始搜索它对应于第一个键字符的链接。有两种情况:
     * 1. 链接存在。沿着链接移动到树的下一个子层。算法继续搜索下一个键字符。
     * 2. 链接不存在。创建一个新的节点，并将它与父节点的链接相连，该链接与当前的键字符相匹配。
     * 时间复杂度：O(m)，其中 mm 为键长。
     * 在算法的每次迭代中，我们要么检查要么创建一个节点，直到到达键尾。只需要 m 次操作
     * 空间复杂度：O(m)
     * 最坏的情况下，新插入的键和 Trie 树中已有的键没有公共前缀。此时需要添加 m 个结点，使用 O(m) 空间
     * @param str
     */
    public void insert(String str){
         TreeNode node = root;
         for(int i = 0; i<str.length();i++){
             char ch = str.charAt(i);
             if(!node.containKey(ch)){
                 // 创建一个新的结点
                 node.put(ch,new TreeNode());
             }
             //从前缀树中获取字符串最后一个字符，将它设为结尾
             node = node.get(ch);
         }
         node.setEnd();
    }

    /**
     * 在 Trie 树中查找键：
     * 存在链接。我们移动到该链接后面路径中的下一个节点，并继续搜索下一个键字符
     * 不存在链接。若已无键字符，且当前结点标记为 isEnd，则返回 true。否则有两种可能，均返回 false：
     * 1. 还有键字符剩余，但无法跟随 Trie 树的键路径，找不到键
     * 2. 没有键字符剩余，但当前结点没有标记为 isEnd。也就是说，待查找键只是Trie树中另一个键的前缀
     * 时间复杂度 : O(m)。算法的每一步均搜索下一个键字符。最坏的情况下需要 m 次操作
     * @param str
     * @return
     */
    public TreeNode searchPrefix(String str){
        TreeNode node = root;
        for(int i = 0; i<str.length();i++){
            char ch = str.charAt(i);
            if(node.containKey(ch)){
               node = node.get(ch);
            }else{
                return null;
            }
        }
        // returns the node where search ends
        return node;
    }
    //判断字符串是否在前缀树中
    public boolean search(String str){
        TreeNode node = searchPrefix(str);
        return node!=null && node.isEnd();
    }

    /**
     * 查找 Trie 树中的键前缀：
     * 查找前缀是否在树中，而不是键
     */
    public boolean startWith(String prefix){
        TreeNode node = searchPrefix(prefix);
        return node!=null;
    }

}
