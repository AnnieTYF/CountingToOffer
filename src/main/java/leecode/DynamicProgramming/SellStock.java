package leecode.DynamicProgramming;

import java.util.Map;

public class SellStock {
    public int maxProfit(int[] prices) {
        int res = 0;
         for(int i = 0; i<prices.length ; i++){
             for(int j = i+1; j<prices.length;j++){
                 if(prices[i] < prices[j]){
                     res = Math.max(res,prices[j]-prices[i]);
                 }
             }
         }
         return res;
    }

    public int maxProfit2(int[] prices) {
        int res = 0;
        for(int i = 1; i< prices.length ; i++){
            if(prices[i] > prices[i-1]){
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }

    /**
     * 不限交易次数
     * 如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]) = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
     * 我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     * @param prices
     * @return
     */
    public int maxProfit22(int[] prices) {
        //防止输入为空
        if(prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i<prices.length; i++){
                //base case
                if(i-1 == -1){
                    dp[i][0] = 0;
                    dp[i][1] = -prices[i];
                    continue;
                }
                dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        // 穷举了 n × max_k × 2 个状态
        return dp[prices.length-1][0];
    }
    public int maxProfit23(int[] prices) {
        //防止输入为空
        if(prices.length == 0){
            return 0;
        }
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for(int i = 0; i<prices.length; i++){
            int temp = dp0;
            dp0 = Math.max(dp0 , dp1 + prices[i]);
            dp1 = Math.max(dp1,temp - prices[i]);
        }
        // 穷举了 n × max_k × 2 个状态
        return dp0;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
     */
    /**
     * 选择：buy, sell rest
     * 状态：天数，交易次数，交易前的状态（0--没有股票，1--持有股票）
     * 0 ->0 选择rest；0->1选择buy
     * 1->1 选择rest；1->0选择sell
     * i 为天数，k为交易次数
     * dp[i][k][0]
     * dp[i][k][1]
     * 结束条件：
     * dp[n-1][k][0] 即最后一天，最多允许 K 次交易，手上无持股，最多获得多少利润
     * 动态转移方程：                           天数由昨天的决定 交易次数-1
     * dp[i][k][0] = Math.max(dp[i-1][k][0] , dp[i-1][k][1] + prices[i]）
     * dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i] )
     * 这个k-1可以在buy的时候，也可以在sell的时候，二选一，因为两步为一次交易
     * basecase 特殊情况结束：
     * dp[-1][k][0] = dp[i][0][0] = 0
     * dp[-1][k][1] = dp[i][0][1] = -infinity(负无穷)
     * 当 i= -1时，因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        //防止输入为空
        if(prices.length == 0){
            return 0;
        }
        int max_k = 2;
         int[][][] dp = new int[prices.length][max_k+1][2];
         for(int i = 0; i<prices.length; i++){
             //因为这里 k=2，所以要对k进行穷举
             for(int k = max_k; k>=1; k--){
                 //base case
                 if(i-1 == -1){
                     dp[i][k][0] = 0;
                     dp[i][k][1] = -prices[i];
                     continue;
                 }
                 dp[i][k][0] = Math.max(dp[i-1][k][0] , dp[i-1][k][1] + prices[i]);
                 dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i]);
             }
         }
        // 穷举了 n × max_k × 2 个状态
         return dp[prices.length-1][max_k][0];
    }

    //冷静期一天
    public int maxProfit4(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        // 代表 dp[i-2][0]
        int dpPre0 = 0;
        for(int i = 0; i<prices.length;i++){
            int temp = dp0;
            dp0 = Math.max(dp0, dp1+prices[i]);
            dp1 = Math.max(dp1, dpPre0 - prices[i]);
            dpPre0 = temp;
        }
        return dp0;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易
     * 动态转移方程：                           天数由昨天的决定 交易次数-1
     * dp[i][k][0] = Math.max(dp[i-1][k][0] , dp[i-1][k][1] + prices[i]）
     * dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i] )
     * 这个k-1可以在buy的时候，也可以在sell的时候，二选一，因为两步为一次交易
     * basecase 特殊情况结束：
     * dp[-1][k][0] = dp[i][0][0] = 0
     * dp[-1][k][1] = dp[i][0][1] = -infinity(负无穷)
     */
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        for(int i = 0 ; i<n; i++){
            for(int j = k; j>=1 ; j--){
                //base case
                if(i-1 == -1){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[n-1][k][0];
    }
}
