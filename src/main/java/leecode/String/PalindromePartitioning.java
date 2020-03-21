package leecode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class PalindromePartitioning {
    /**
     * 分割回文串
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return all possible palindrome partitioning of s.
     * 例如：
     * Input: "aab"
     * Output:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     */

    /**
     * 解法一：深度遍历 + 回溯 +使用动态规划预处理数组
     * 要实现分割回文串的功能，有两个步骤：
     * 1. 字符串的所有分割的可能情况
     * 2. 判断每个分割的部分是不是回文串
     * 参考文章 https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        // 预处理,分割的字符的范围
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        //这里，如果dp[i + 1][j - 1]为true那么dp[i][j]才有资格判断是不是回文
        //abca ， s[0] == s[3] 但是 s[1] != s[2]所以 dp[0][3]不是回文
        for (int right = 0; right < s.length(); right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        helper(result,new ArrayList<>(),dp,s,0);
        return result;
    }
    //所有可能分割情况
    private static void helper(List<List<String>> res, List<String> path, boolean[][] dp , String s, int pos){
       if(pos == s.length()){
          res.add(new ArrayList<>(path));
          return;
       }
       for(int i = pos;i<s.length();i++){
           // 剪枝
          if(dp[pos][i]){
              path.add(s.substring(pos,i+1));
              helper(res,path,dp,s,i+1);
              //让path重新为空，每次递归回上一层就删除一个path中的数
              path.remove(path.size()-1);
          }
       }
    }
    public static void main(String args[])
    {
        String s = "abbab";
        System.out.println(partition(s).toString());
        HashMap map = new HashMap<>();
        Hashtable hashtable = new Hashtable();
    }
}
