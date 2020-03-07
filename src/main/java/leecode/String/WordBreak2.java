package leecode.String;

import java.util.*;

public class WordBreak2 {
    /**
     *给定一个非空字符串 s 和一个包含非空单词列表的字典wordDict，
     * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
     * 说明：
     * 分隔时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 这次的输出要求是一个字符串list而不是判断在不在其中了
     *例如：
     * 输入:
     * s = "catsanddog"
     * wordDict = ["cat", "cats", "and", "sand", "dog"]
     * 输出:
     * [
     *   "cats and dog",
     *   "cat sand dog"
     * ]
     * 输入:
     * s = "catsandog"
     * wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出:
     * []
     */
    /**
     * 记忆回溯法
     * hashmap
     * 我们使用一个 key:value 这样的哈希表来进行优化。在哈希表中，key 是当前考虑字符串的开始下标，
     * value包含了所有从头开始的所有可行句子。
     * 下次我们遇到相同位置开始的调用时，我们可以直接从哈希表里返回结果，而不需要重新计算结果。
     * 通过记忆化的方法，许多冗余的子问题都可以被省去，回溯树得到了剪枝，所以极大程度降低了时间复杂度
     * 时间复杂度：O(n^3)
     * 回溯树的大小最多 n^2
     * 创建列表需要 n 的时间
     * @param s
     * @param wordDict
     * @return
     */
    public static List<String> wordBreak(String s, List<String> wordDict) {
       return word_Break(s,wordDict,0);
    }
    static HashMap<Integer,List<String>> map = new HashMap<>();
    private static List<String> word_Break(String s, List<String> wordDict, int start){
        if(map.containsKey(start)){
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if(start == s.length()){
            res.add("");
        }
        for(int end = start+1 ; end <= s.length();end++){
           if(wordDict.contains(s.substring(start,end))){
               List<String> list = word_Break(s,wordDict,end);
               for(String l : list){
                   //单词拼接
                   res.add(s.substring(start,end) + (l.equals("")?"":" ")+l);
               }
           }
        }
        map.put(start,res);
        return res;
    }
    public static void main(String args[])
    {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(wordBreak(s, wordDict));
    }
}
