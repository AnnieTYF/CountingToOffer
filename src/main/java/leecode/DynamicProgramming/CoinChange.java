package leecode.DynamicProgramming;

import sun.applet.Main;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 给定不同面额的硬币 coins 和一个总金额amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 */
public class CoinChange {
    /**
     * 递归，要先列出状态方程,n代表amount
     * fn = 0 , n = 0
     *    = 1 + min(amount-ci) i为硬币面额
     * COUNT(amount11) = minCOUNT(amount(11-ci))
     * 运行超时
     * @param coins
     * @param amount
     * @return
     */
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        solution(coins,amount,0);
        if(res == Integer.MAX_VALUE){
            return -1;
        }
       return res;
    }
    public void solution(int[] coins, int amount,int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res = Math.min(res,count);
        }
        for(int i = 0;i < coins.length;i++){
            solution(coins,amount-coins[i],++count);
        }
    }

    /**
     * 带备忘录的递归算法
     * 记忆化搜索是先从 memo[amonut-1]memo[amonut−1] 开始，从上到下
     * @param coins
     * @param amount
     * @return
     */
    static int[] memo;
    public static int coinChange2(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memo = new int[amount];
        return  solution2(coins,amount);
    }
    public static int solution2(int[] coins, int amount){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        if(memo[amount-1]!=0){
            return memo[amount-1];
        }
        int count = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            int res = solution2(coins,amount-coins[i]);
            if(res >= 0 && res < count){
                count = ++res;
            }
        }
        memo[amount-1] = (count == Integer.MAX_VALUE ? -1 : count);
        return memo[amount-1];
    }

    /**
     * 动态规划，自下向上
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange3(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        /*
         给dp赋初值，最多的硬币数就是全部使用面值1的硬币进行换
         amount + 1 是不可能达到的换取数量，于是使用其进行填充
         */
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i = 1; i<=amount;i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i],dp[i - coin]+1);
                }
            }
        }
        return dp[amount] == (amount+1)? -1:dp[amount];
    }

    public static void main(String[] args) {
       int[] coins = {1,2,5};
       int amount = 11;
        System.out.println(coinChange2(coins, amount) );
    }

    public int change2(int amount, int[] coins) {
        int len = coins.length;
        //若只使用 coins 中的前 i 个硬币的面值，若想凑出金额 j，有 dp[i][j] 种凑法
        int[][] dp = new int[len+1][amount+1];
        for(int j = 0; j<= amount; j++){
            dp[0][j] = 0; //没有选项的时候只有0种方法
        }
        for(int i = 0; i<=len ; i++){
            dp[i][0] = 1; //容量为0的凑数方法为1
        }
        for(int i = 1; i<=len ; i++){
            for(int j = 1; j <= amount ; j++){
                if(j - coins[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    //例如想用面值为i=2的硬币凑出5的方法 = 面值为1的硬币凑出5 + 面值为2的硬币凑出 3
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[len][amount];
    }
    public int change(int amount, int[] coins) {
        int len = coins.length;
        //若只使用 coins 中的前 i 个硬币的面值，若想凑出金额 j，有 dp[i][j] 种凑法
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i< len ; i++){
            for(int j = 1; j <= amount ; j++){
                if(j - coins[i] >= 0){
                    //例如想用面值为i=2的硬币凑出5的方法 = 面值为1的硬币凑出5 + 面值为2的硬币凑出 3
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }

}
