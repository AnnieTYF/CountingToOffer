package leecode.DynamicProgramming;
/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class CanPartition {
    /**
     * 动态规划
     * 这道题是01背包问题的变形，我们求出数组的总和sum 将他转换为背包问题
     * 给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。
     * 现在让你装物品，是否存在一种装法，能够恰好将背包装满？
     * 状态转移方程: dp[i][j] = dp[i-1][j] ||dp[i - 1][j-nums[i-1]]
     * base case ：dp[..][0] = true 和 dp[0][..] = false
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
         int sum = 0;
        int total;
         int len = nums.length;
         for(int num : nums){
             sum += num;
         }
         if(sum%2 == 0){
             total = sum/2;
         }else{
             return false;
         }
         boolean[][] dp = new boolean[len+1][total+1];
        for(int j = 0; j<=total;j++){
            //没有物品可选择
            dp[0][j] = false;
        }
         for(int i = 0; i<=len;i++){
             //背包没有空间
             dp[i][0] = true;
         }
         for(int i = 1; i<= len;i++){
              for(int j = 1 ; j<= total ; j++){
                   if(j - nums[i-1] < 0){
                       // 背包容量不足，不能装入第 i 个物品
                       dp[i][j] = dp[i-1][j];
                   }else{
                       //不装 / 装
                       dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                   }
              }
         }
         return dp[len][total];
    }

    /**
     * 优化，状态压缩
     * @param nums
     * @return
     */
    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        int total;
        int len = nums.length;
        for(int num : nums){
            sum += num;
        }
        if(sum%2 == 0){
            total = sum/2;
        }else{
            return false;
        }
        boolean[] dp = new boolean[total + 1];
        dp[0] = true;
        for(int i = 0; i< len;i++){
            for(int j = total ; j>= 0 ; j--){
                if(j - nums[i]>= 0){
                    // 背包容量不足，不能装入第 i 个物品
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
            }
        }
        return dp[total];
    }
    public static void main(String args[]){
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
