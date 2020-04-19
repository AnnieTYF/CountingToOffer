package leecode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 输入: [1,2,3]
 * 输出: 6
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * 这道题的核心是注意负数
 */
public class MaximumProduct {
//这个比较特殊，不需要注意负数的个数，因为一共就两种情况
  public int maximumProduct(int[] nums) {
      int sum = 1;
      int len = nums.length;
      if(len < 3){
          for(int i = 0; i<len;i++){
              sum *= nums[i];
          }
          return sum;
      }
      Arrays.sort(nums);
      return Math.max(nums[0] * nums[1] * nums[len-1],nums[len-1]*nums[len-2]*nums[len-3]);
    }
    //方法二，线性扫描，取出数组中最大的三个数，和最小的两个数
    public int maximumProduct2(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

}
