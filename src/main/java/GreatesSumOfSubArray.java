public class GreatesSumOfSubArray {
    /**
     * `在古老的一维模式识别中,常常需要计算连续子向量的最大和,
     * 当向量全为正数的时候,问题很好解决。
     * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * 给一个数组，返回它的最大连续子序列的和？(子向量的长度至少是1)
     */

    /**
     * 解法一：动态规划，每走一步都是它的最大值
     * 16ms
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int thisSum = array[0];
        int maxSum = array[0]; //注意初始值 不能设为0 防止只有负数
        for(int i =1 ; i< array.length ; i++){
            //这段代码也可以写的简洁点
            // thisSum = (thisSum<0)?array[i]:thisSum+array[i];
             thisSum += array[i];
            if(thisSum < array[i]){
                //全是负数情况
                /*
                  题目要求连续子向量（设为X）的和的最大值，
                  如果dp[i-1]+array[i]<array[i]，那么之前计算dp[i-1]的子向量肯定不是所求X的开头段，
                  因为array[i]已经更大了，它才有可能是X的开头段。
                 */
                thisSum = array[i];
            }
            if(thisSum > maxSum){
                maxSum = thisSum;
            }
        }
        return maxSum;
    }
    /**
     *  * 可以看一下别人的代码
     *      * F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     *      * F（i）=max（F（i-1）+array[i] ， array[i]）
     *      * res：所有子数组的和的最大值
     *      * res=max（res，F（i））
     *
     * public  int FindGreatestSumOfSubArray(int[] array) {
     *         int res = array[0]; //记录当前所有子数组的和的最大值
     *         int max=array[0];   //包含array[i]的连续数组最大值
     *         for (int i = 1; i < array.length; i++) {
     *             max=Math.max(max+array[i], array[i]);
     *             res=Math.max(max, res);
     *         }
     *         return res;
     * }
     */
}
