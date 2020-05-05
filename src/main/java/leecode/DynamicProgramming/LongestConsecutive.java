package leecode.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int res = 1;
        int length = 1;
        for(int i = 1; i < nums.length ; i++){
            //去重，防止[1,2,0,1]这种情况
                if(nums[i] != nums[i-1]){
                    if(nums[i] == nums[i-1]+1){
                        length++;
                    }else{
                        res = Math.max(res,length);
                        //长度重置
                       length = 1;
                    }
                }
        }
        //最后一次到数组尾部的判断
        return Math.max(res,length);
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive( nums));
    }
}
