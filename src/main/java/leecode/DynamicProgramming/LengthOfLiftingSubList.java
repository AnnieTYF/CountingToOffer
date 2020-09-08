package leecode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 这是一个典型的动态规划的题
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 */

/**
 *方法一：动态规划，我不是很懂
 * 时间复杂度：O(n^2)
 * 其中 n 为数组 nums 的长度。动态规划的状态数为 n，计算状态 dp[i]时，需要 O(n)
 *  的时间遍历 dp[0…i−1] 的所有状态，所以总时间复杂度为 O(n^2)
 */
public class LengthOfLiftingSubList {
    public static int lengthOfLIS(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }

        //dp[i] 表示以 nums[i] 结尾的「上升子序列」的长度
         int[] dp = new int[nums.length];
        //初始化，1 个字符显然是长度为 1 的上升子序列
         dp[0] = 1;
         int maxAns = 1;
         for(int i = 1; i<nums.length;i++){
             for(int j = 0 ; j < i ; j++){
                 if(nums[j] < nums[i]){
                     dp[i] = Math.max(dp[i], dp[j] + 1);
                 }
             }
             //输出不能返回最后一个状态值，还是根据定义，最后一个状态值只是以 nums[len - 1] 结尾的「上升子序列」的长度
             //状态数组 dp 的最大值才是最后要输出的值
             maxAns = Math.max(maxAns,dp[i]);
         }
         return maxAns;
    }

    /**
     * 方法二：动态规划的优化，修改状态定义,使用贪心+二分
     * 考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，
     * 则我们需要让序列上升得尽可能慢，因此我们希望每次在上升子序列最后加上的那个数尽可能的小
     * 基于上面的贪心思路，我们维护一个数组 d[i] ，表示长度为 i + 1 的所有上升子序列的结尾的最小值
     * dp 也是一个严格上升数组
     * 最后整个算法流程为：
     * 1. 设当前已求出的最长上升子序列的长度为 len（初始时为 11），从前往后遍历数组 nums
     * 2. 在遍历到 nums[i] 时：如果 nums[i]>d[len] ，则直接加入到 d 数组末尾，并更新 len=len+1；
     * 3. 否则，在 d 数组中二分查找，找到第一个比 nums[i] 小的数 d[k] ，并更新 d[k+1]=nums[i]。
     * 以输入序列 [0, 8, 4, 12, 2]为例：
     * 第一步插入 00，d = [0]；
     * 第二步插入 88，d = [0, 8]；
     * 第三步插入 44，d = [0, 4]；
     * 第四步插入 12，d = [0, 4, 12]；
     * 第五步插入 22，d = [0, 2, 12]。
     * 最终得到最大递增子序列长度为 3。
     * 时间复杂度 O(nlogn):遍历数组使用了 O(N)，二分查找法使用了 O(logN)
     * 0 ms
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int len = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i<nums.length;i++){
            if(nums[i] > dp[len]){
                //如果有序数组 tail 中存在大于 num 的元素，找到第 1 个，让它变小，
                // //这样我们就找到了一个结尾更小的相同长度的上升子序
                dp[++len] = nums[i];
            }else{
                //二分查找
                int low = 0;
                int high = len;
                if(low == high){
                    dp[low] = nums[i];
                }
                while(low < high){
                    // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                    int mid = low + (high-low)/2;
                    if(dp[mid] < nums[i]){
                        low = mid+1;
                    }else{
                        high = mid;
                    }
                }
                //一定能找到第 1 个大于等于 nums[i] 的元素
                dp[low] = nums[i];
            }
        }
        return len+1;
    }

    public static void main(String[] args) {
         int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS2(nums));
    }
}
