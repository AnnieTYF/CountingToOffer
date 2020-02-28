package leecode.Array;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedArray {
    /**
     * 题目要求：
     * Given a sorted array nums, remove the duplicates in-place such
     * that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this by
     * modifying the input array in-place with O(1) extra memory
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
     * @param nums
     * @return
     */

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
           return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
       int flag = 0;
        int temp = nums[0];
       for(int i = 0; i<nums.length;i++){
           if(flag == 0){
              temp = nums[i];
              flag++;
           }else if(temp == nums[i]){
                flag++;
           }else{
               flag--;
           }
       }
       flag = 0;
       for(int i = 0; i<nums.length;i++){
           if(temp == nums[i]){
              flag++;
           }
       }
       return (flag > nums.length/2) ? temp : 0;
    }

    public static void main(String args[]){
      int[] nums = {3,3,4};
        System.out.println(removeDuplicates(nums) );
    }

}
