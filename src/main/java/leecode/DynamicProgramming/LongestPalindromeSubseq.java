package leecode.DynamicProgramming;

import java.util.Arrays;

public class LongestPalindromeSubseq {

    /**
     * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度
     * dp[i][j] 在子数组 i..j 种，满足条件的 子序列的长度dp[i][j]
     * "bbbab" 一个可能的最长回文子序列为 "bbbb" 长度为 4
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i< len ; i++){
            dp[i][i] = 1; //如果只有一个字符，显然最长回文子序列长度是 1，也就是dp[i][j] = 1,(i == j)
        }
        for(int i = len-1; i >= 0 ; i--){
            for(int j = i+1; j < len ; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2; //一次对比两个字符
                }else{
                    dp[i][j] =Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][len-1];
    }
}
