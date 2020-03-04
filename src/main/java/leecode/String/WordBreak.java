package leecode.String;

import java.util.List;

public class WordBreak {
    /**
     * Given a non-empty string s and a dictionary wordDict containing a list
     * of non-empty words, determine if s can be segmented into a
     * space-separated sequence of one or more dictionary words.
     * Note:
     * 1. The same word in the dictionary may be reused multiple times in the segmentation.
     * 2. You may assume the dictionary does not contain duplicate words.
     * 举例:
     * Input: s = "applepenapple", wordDict = ["apple", "pen"]
     * Output: true
     * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output: false
     */
    /**
     * 解法一：动态规划
     * 遍历字符串的各种可能，如果包含在wordDict中，就将字符串此时的尾部标记为true，
     * boolean[] dp其实记录的是字符串的分割
     * 如果 dp[left] = true说明上一个字符串是在这里结束的
     * dp[left]=T 和 dp[right]=T之间就是一个包含在字典里的字符串
     * 所以如果dp的最后一位为true，说明字符串一直分割到了最后
     * 那么就肯定在字典中了
     * 其实我想到了昨天做的分割回文串里，动态规划，有一个boolean[] dp
     * 时间复杂度：O(n^2)，求出 dp 数组需要两重循环
     * 空间复杂度：O(n)。 dp数组的长度是 n+1
     * tips：如果想再加快运行速度，可以添加一行代码
     * Set<String> wordDictSet=new HashSet(wordDict);
     * 取消字典里重复的，这样contains方法效率应该会提高
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        //注意一点，1. 我们默认dp[0]是空字符串，为true，所以dp[s.length()+1]
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        //既然默认第一个了，right就要从1开始，并且right <= s.length()
        //因为我们最后要判断dp[s.length()]
            for (int right = 1; right <= s.length(); right++) {
                for (int left = 0; left < right; left++) {
                    if (dp[left] && wordDict.contains(s.substring(left, right))) {
                        dp[right] = true;
                        break;
                    }
                }
            }
          return dp[s.length()];
    }
    /**
     * 还有使用树的
     * https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode/
     */

}
