package leecode.Array;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(right < nums.length) {
            //移入窗口的数字
            sum += nums[right];
            // 右移窗口
            right++;
            // 判断左侧窗口是否要收缩
            while (sum >= s) {
                // 进行一些结果判断
                res = Math.min(res,right-left);
                // 移出窗口
                sum -= nums[left];
                // 左移窗口
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0:res;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;;
        while(right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                res = Math.min(res,right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res ==Integer.MAX_VALUE ? 0 :res;
    }

    public static void main(String args[]){
        int[] nums = {2,3,1,2,4,3};
        minSubArrayLen(7,  nums) ;
    }
}
