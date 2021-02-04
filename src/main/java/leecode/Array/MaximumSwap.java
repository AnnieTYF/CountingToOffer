package leecode.Array;

import java.util.Arrays;

public class MaximumSwap {
    //如果数组是降序，那他本身就是最大值，所以我觉得最大的数就是数组降序一次
    public int maximumSwap2(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[] maxIndexs = new int[nums.length];
        int max = nums.length-1;
        //从右向左建立一个数组arr用于保存该数右边最大的数的索引，如果有这个数，那么保存索引，没有就是-1
        for(int i = nums.length-1; i>=0 ; i--){
            //如果当前值比最大值大，那么我们更新最大值，并更新max，并将arr索引设为-1,表示这个数右边没有比他大的值
            if(nums[i] > nums[max]){
                max = i;
                maxIndexs[i] = -1;
            }else{
                maxIndexs[i] = max;
            }
        }
        //从左到右遍历arr，如果arr不为-1，那么交换原字符中索引为arr[i]与i的值
        for(int i = 0; i<maxIndexs.length ; i++){
            if(maxIndexs[i] != -1 && nums[i]!=nums[maxIndexs[i]]){
                char temp = nums[i];
                nums[i] = nums[maxIndexs[i]];
                nums[maxIndexs[i]] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(nums));
    }

    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[] lastIndex = new int[10];
        //记录每个数字出现的最后位置索引，因为数组无非0-9
        for(int i = 0; i<nums.length ; i++){
            lastIndex[nums[i]-'0'] = i;
        }
        //从左到右遍历arr，贪心算法
        for(int i = 0; i<nums.length ; i++){
            //比当前数字大的数，数字范围最大从9开始
            for(int j = 9; j>nums[i]-'0';j--){
                //如果比当前数大的数不存在，则lastIndex[j]为0，如果存在，则交换
                if(lastIndex[j] > i){
                    char temp = nums[i];
                    nums[i] = nums[lastIndex[j]];
                    nums[lastIndex[j]] = temp;
                    break; //仅交换一次
                }
            }
        }
        return Integer.parseInt(new String(nums));
    }
}
