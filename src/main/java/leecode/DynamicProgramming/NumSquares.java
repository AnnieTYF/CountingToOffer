package leecode.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少
 * 其实这道题本质上是零钱兑换问题
 * https://leetcode-cn.com/problems/perfect-squares/
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 */
public class NumSquares {
    /**
     * 动态规划
     * n = 12
     * 12对应的平方数[1,4,9]
     * 分别计算 [12-k] k为平方数（1，4，9）
     * 状态转化方程：dp(n) = min(dp(n-i)+1,dp[i]),i为可能的平方数
     * 求最少的运算次数,dp[n]就是最后的答案
     * @param n
     * @return
     */
    public int numSquares(int n) {
         int[] dp = new int[n+1];
         //dp默认为最大值
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        //自底向上，从1开始每个数的最少的运算次数
        for(int i = 1; i<=n ; i++){
            //从1开始可能的平方数（1，4，9）
            for(int j = 1 ; i - j*j >= 0;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
