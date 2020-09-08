package leecode.Array;

public class ProductExceptSelf {
    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中
     * output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        //构造前缀
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i-1];
        }
        int last = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            int right = last * nums[j+1];
            res[j] = res[j] * right;
            last = right;
        }
        return res;
    }

    public static void main(String args[]) {
        int[] nums = {1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }
}
