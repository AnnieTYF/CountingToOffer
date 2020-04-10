package leecode.DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h)出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 */
public class MaxEnvelopes {
    /**
     * 肯定用动态规划，那第一步就是要找状态，肯定也是信封组数
     * 首先要将元素进行排序 + 最长子序列
     * 在对信封按 w 进行排序以后，我们可以找到 h 上最长递增子序列的长度
     * 像这种两组数据的，都是按照一组排序，另一组找最长子序列
     * 按 w 进行升序排序，若 w 相同则按 h 降序排序
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
         int result = 1;
         int len = envelopes.length;
         if(len < 2){
             return len;
         }
        for(int i = 0; i<len-1;i++){
             for(int j = i; j<len;j++){
                 if(envelopes[j][0] < envelopes[i][0] ){
                     int a = envelopes[i][0];
                     int b = envelopes[i][1];
                     envelopes[i][0] = envelopes[j][0];
                     envelopes[i][1] = envelopes[j][1];
                     envelopes[j][0] = a;
                     envelopes[j][1] = b;
                 }
             }
         }
         int[] dp = new int[len];
        Arrays.fill(dp,1);
         for(int i = 0; i<len;i++){
             for(int j = 0; j<i;j++){
                 if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                     //每当有一个符合条件的，就将自身和他的最长子序列比
                     dp[i] = Math.max(dp[i],dp[j]+1);
                 }
             }
             result = Math.max(result,dp[i]);
         }

         return result;
    }
  //代码优化，二维数组降维求最长子序列
    public static int maxEnvelopes2(int[][] envelopes) {
        int len = envelopes.length;
        if(len < 2){
            return len;
        }
        //排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });

        //对高进行最长子序列
        int[] hight = new int[len];
        for(int i =0 ;i<len;i++){
            hight[i] = envelopes[i][1];
        }
        int[] dp = new int[len];
        int end = 0;
        for(int num : hight){

            int i = Arrays.binarySearch(dp, 0, end, num);
            //因为Arrays.binarySearch没找到返回-1，或者返回负的插入点
            //插入点是索引键将要插入数组的那一点，即第一个大于该键的元素索引
            /*
            例如：
            int a[] = new int[] {1, 3, 4, 6, 8, 9};
            int x1 = Arrays.binarySearch(a, 5);
            返回 x1=-4，返回的插入点是6所在的索引的负数
            所以在这个算法中我们要对他进行+1处理
             */
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            //如果插入的元素比末尾元素大，则将当前元素插入数组中 end+1
            if (i == end) {
                end++;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }
}
