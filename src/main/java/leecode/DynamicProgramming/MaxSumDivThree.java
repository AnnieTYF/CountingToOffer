package leecode.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxSumDivThree {
/**
 * 此题的约束是被3整除，一个数被3整除，有三种状况：分别是对3取模等于0、对3取模等于1，对3取模等于2
 * 当前状态：dp[动态规划阶段][约束状态]
 * 对于任意一种状态，下一步我们都有两种选择，一是选择当前元素，二是不选择当前元素
 * dp[i][*] = max{dp[i-1][*],dp[i-1][*] + nums[i]}  (* 取值为 0,1,2)
 */
    public int maxSumDivThree(int[] nums) {
        if(nums.length  == 0){
            return 0;
        }
        int[][] dp = new int[nums.length+1][3];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i = 1 ;i <=nums.length ; i++){
            if (nums[i - 1] % 3 == 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][0] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][2] + nums[i - 1]);
            }
            else if (nums[i - 1] % 3 == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + nums[i - 1]);
            }
            else if (nums[i - 1] % 3 == 2) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + nums[i - 1]);
            }
        }
        return dp[nums.length][0];
    }

}
