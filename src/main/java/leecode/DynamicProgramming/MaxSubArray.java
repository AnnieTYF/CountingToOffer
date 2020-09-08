package leecode.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    /**
     * 动态规划
     * dp 数组代表 i 之前子数组的最大和
     * dp[i] = Max(dp[i-1]+num[i], num[i])
     */
    public static int maxSubArray(int[] nums) {
       int ans = nums[0];
       int[] dp = new int[nums.length];
       dp[0] = nums[0];
       for(int i = 1; i<nums.length ; i++){
           dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
           ans = Math.max(ans,dp[i]);
       }
       return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
