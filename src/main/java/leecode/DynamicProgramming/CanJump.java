package leecode.DynamicProgramming;

public class CanJump {

    /**
     * 贪心算法
     */
    public boolean canJump(int[] nums) {
         int n = nums.length;
         int farthest = 0;
         for(int i = 0; i<n ; i++){
             farthest = Math.max(farthest,i+nums[i]);
             if (farthest >= n - 1) {
                 //如果最远可以到达的位置大于等于数组中的最后一个位置，那就说明最后一个位置可达
                 return true;
             }
         }
         return false;
    }

    public int jump(int[] nums) {
         int n = nums.length;
         int end = 0;
         int farthest = 0;
         int jump = 0;
        /**
         * n-1 是因为 在遍历数组时，我们不访问最后一个元素
         * 这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了
         * 如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」
         */
        for(int i = 0; i<n-1; i++){
             farthest = Math.max(i+nums[i],farthest);
             if(end == i){
                   jump++;
                   end = farthest;
             }
         }
         return jump;
    }
}
