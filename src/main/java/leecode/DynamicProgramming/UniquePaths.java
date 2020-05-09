package leecode.DynamicProgramming;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 链接：https://leetcode-cn.com/problems/unique-paths
 */
public class UniquePaths {
    /**
     * 动态规划
     * 无论机器人怎么走，最终都是 m次向右，n次向下
     * 状态：长， 宽 ； 选择：向右走，向下走
     * dp 数组，dp[i][j] = x 表示走到第i行，第j列有x条路径
     * base case d[0][j] = 1，因为只能向下走，d[i][0] = 1 只能向右走
     * 状态转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int j = 0; j<n;j++){
            dp[0][j] = 1;
        }
        for(int i = 0 ; i < m ; i++){
            dp[i][0] = 1;
        }
           for(int i = 1; i<m ; i++){
               for(int j = 1; j< n ; j++){
                   dp[i][j] = dp[i-1][j] + dp[i][j-1];
               }
           }
           return dp[m-1][n-1];
    }

    /**
     * 状态压缩，空间优化
     */
    public static int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
    public static void main(String args[]){
        int m = 3;
        int n = 2;
        System.out.println(uniquePaths( m, n));
    }
}
