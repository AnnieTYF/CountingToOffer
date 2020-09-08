package leecode.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Trap {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
     */
    /**
     * 暴力破解
     * 记录左边最大和右边最大的柱子
     * 存储的水 = min(左边最大，右边最大) - 节点本身高度
     */
    public int trap3(int[] height) {
        int len = height.length;
        int ans = 0;
        for(int i = 1; i<len-1 ; i++){
            int leftMax = 0;
            int rightMax = 0;
            //右边最大值
            for(int j = i; j<len ; j++){
                rightMax = Math.max(rightMax,height[j]);
            }
            //左边最大值
            for(int k = i ; k>= 0 ; k--){
                leftMax = Math.max(leftMax,height[k]);
            }
            ans += Math.min(rightMax,leftMax)-height[i];
        }
        return ans;
    }
    /**
     * 加备忘录优化
     */
    public int trap2(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int len = height.length;
        int ans = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        right[len-1] = height[len-1];
        //左边最大值
        for(int j = 1; j<len ; j++){
            left[j] = Math.max(left[j-1],height[j]);
        }
        //右边最大值
        for(int k = len-2 ; k>= 0 ; k--){
            right[k] = Math.max(right[k+1],height[k]);
        }
        for(int i = 1; i<len-1 ; i++){
            ans += Math.min(right[i],left[i])-height[i];
        }
        return ans;
    }
    /**
     * 双指针优化
     *
     */
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int len = height.length;
        int ans = 0;
        int left = 0;
        int right = len-1;
        int leftMax = height[0]; //leftMax是 height[0..left] 中最高柱子的高度
        int rightMax = height[len-1]; //是 height[right..end] 的最高柱子的高度
        while(left <= right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(leftMax < rightMax){
                ans += leftMax - height[left];
                left++;
            }else{
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

}
