package leecode.DynamicProgramming;

public class FindTargetSumWays {

    /**
     * 该问题可以等价于一个找子集问题
     * 找到nums一个正子集和负子集，使得最后两个子集总和等于target
     * 所以问题转换为 找到一个nums的子集P，使得 sum(P) = (target + sum(nums)）/2
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        int len = nums.length;
        for(int num : nums){
            sum+=num;
        }
        if(sum < Math.abs(S) || (sum+S)%2!=0){
            return 0;
        }
        int target = (sum+S)/2;
        //dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数
         int[][] dp = new int[len+1][target+1];
        for(int j = 0; j<=target;j++){
            dp[0][j] = 1;   //没有物品可选择
        }
        for(int i = 0; i<=len;i++){
            dp[i][0] = 1;      //背包没有空间
        }
         for(int i = 1; i<=len ; i++){
             for(int j = 1; j<=target ; j++){
                  if(j - nums[i-1] < 0){
                      dp[i][j] = dp[i-1][j]; // 容量不足，不能装入第 i 个物品
                  }else{
                      dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                  }
             }
         }
         return dp[len][target];
    }
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        int len = nums.length;
        for(int num : nums){
            sum+=num;
        }
        if(sum < Math.abs(S) || (sum+S)%2!=0){
            return 0;
        }
        int target = (sum+S)/2;
        //dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i = 1; i<=len ; i++){
            for(int j = target; j>=nums[i-1] ; j--){
                dp[j] = dp[j] + dp[j-nums[i-1]];
            }
        }
        return dp[target];
    }
}
