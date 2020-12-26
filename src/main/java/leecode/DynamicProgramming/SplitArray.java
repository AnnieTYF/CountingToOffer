package leecode.DynamicProgramming;

import java.util.Map;

public class SplitArray {

    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
         for(Integer num : nums){
             sum += num;
             max = Math.max(max,num);
         }
         //最小的最大值的区间，改成二分查找
         int left = max;
         int right = sum;
         while(left<right){
             int mid = left+(right-left)/2;
             int n = split(nums,mid);
             if(n == m){
                 // 收缩右边界，达到搜索左边界的目的
                 right = mid;
             }else if(n < m){
                 // 最大子数组和上限高了，减小一些
                 right = mid;
             }else {
                 // 最大子数组和上限低了，增加一些
                 left = mid+1;
             }
         }
         return left;
    }
    //若限制最大子数组和为 max，计算 nums 至少可以被分割成几个子数组
    public int split(int[] nums, int maxSum){
        // 至少可以分割的子数组数量
        int count = 1;
        int sum = 0;// 记录每个子数组的元素和
        for(int i = 0; i<nums.length ; i++){
            if(sum+nums[i] > maxSum){
                count++; // 如果当前子数组和大于 max 限制,则这个子数组不能再添加元素了
                sum = 0;
            }else{
                sum += nums[i]; // 当前子数组和还没达到 max 限制,还可以添加元素
            }
        }
        return count;
    }
}
