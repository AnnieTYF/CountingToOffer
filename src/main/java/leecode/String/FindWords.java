package leecode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 * 人家代码写的真的好
 * https://leetcode-cn.com/problems/word-search-ii/solution/dan-ci-sou-suo-ii-by-leetcode/
 */
class TrieNode{
    //因为在这个字典树中，每个结点包括他的子节点的连接，不用固定26个
    //key 为对应字符，value为对应字符的子节点
    HashMap<Character,TrieNode> children = new HashMap<>();
    //结点结束标志，结束位string不为null
    String word = null;
    public TrieNode(){ }
}
public class FindWords {
    static List<String> result = new ArrayList<>();
   static char[][] _board = null;
    public static List<String> findWords(char[][] board, String[] words) {

       //构建前缀树
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for (Character letter : word.toCharArray()){
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                }else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter,newNode);
                    node = newNode;
                }
            }
            //每个尾结点保存着单词，比如说root下面有 oath，h里保存单词，word != null，表示结束位
            node.word = word;
        }
        _board = board;
        //回溯前缀树,先遍历矩阵，如果当前字符在前缀树中存在，再开始遍历，否则对于不存在的单词不予以回溯
        //这里很重要，遍历矩阵相当于把矩阵的每一个点当成一个单词的可能开始点
        //然后根据当前点，回溯上下左右，看是否可能与前缀树匹配
        for(int row = 0; row<board.length;row++){
            for(int col = 0 ; col < board[row].length; col++){
               if(root.children.containsKey(board[row][col])){
                   backtracking(row, col, root);
               }
            }

        }
        return result;
    }

    /**
     * 回溯前缀树
     * @param row
     * @param col
     */
    static public void backtracking(int row, int col, TrieNode parent){
        Character letter = _board[row][col];
        TrieNode curNode = parent.children.get(letter);
        //检查是否是结束结点，是否匹配
        if(curNode.word != null){
            result.add(curNode.word);
            curNode.word = null;
        }
        //mark the current letter before the EXPLORATION，路过且有用的位置，设为#
        // 防止出现死循环，防止周围元素相同又回到原元素的情况
        // a b a
        //   a
        _board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        //学习一下人家是怎么遍历的
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            //数组越界直接跳过
            if (newRow < 0 || newRow >= _board.length || newCol < 0
                    || newCol >= _board[0].length) {
                continue;
            }
            if (curNode.children.containsKey(_board[newRow][newCol])) {
                backtracking(newRow, newCol, curNode);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.，将#换回原元素
        //递归回调，防止影响下一次遍历
        _board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes，删除前缀树遍历过的单词
        //不需要检查结果集中是否有任何重复项。因此，我们可以简单地使用一个列表而不是集合来保存结果，这样可以加快解决方案的速度
                 if (curNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
    public static void main(String[] args){
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","eat","rain","pea"};
        findWords( board, words);
    }
}

