package leecode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0？
 * 请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i<nums.length;i++){
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(nums[i] > 0){
                return res;
            }
            // 去重
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int pre = i+1;
            int last = nums.length-1;
            while(pre < last){
                int sum = nums[i] + nums[pre] + nums[last];
                if(sum < 0){
                    pre++;
                }else if(sum > 0){
                    last--;
                }else {
                    //找到一组后还要继续往下遍历
                    res.add(Arrays.asList(nums[i],nums[pre],nums[last]));
                    while (pre < last && nums[pre] == nums[pre+1]) pre++; // 去重
                    while (pre < last && nums[last] == nums[last-1]) last--; // 去重
                    pre++;
                    last--;
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }
}
