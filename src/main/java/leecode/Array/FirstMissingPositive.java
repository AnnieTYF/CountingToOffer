package leecode.Array;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
         int n = nums.length;
         for(int i = 0; i<n ; i++){
             //将数组中所有小于等于 0 的数修改为 N+1
             if(nums[i] <= 0){
                 nums[i] = n+1;
             }
         }

         for(int i =0 ; i<n ; i++){
             int num =  Math.abs(nums[i]);
             if(num <= n){
                 //将<=n的元素位置的值标记为负
                 nums[num-1] = -Math.abs(nums[num-1]);
             }
         }
         for(int i = 0; i<n ; i++){
             if(nums[i] > 0){
                 return i+1;
             }
         }
         return n+1;
    }
}
