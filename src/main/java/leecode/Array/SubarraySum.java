package leecode.Array;

public class SubarraySum {
    /**
     * 560. 和为K的子数组
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * 解法一：枚举
     * 考虑以 i 结尾和为 k 的连续子数组个数，我们需要统计符合条件的下标 j 的个数，其中 0≤j≤i 且
     * [j..i] 这个子数组的和恰好为 k
     * 但是如果我们知道 [j,i] 子数组的和，就能 O(1) 推出 [j-1,i]的和，
     * 因此这部分的遍历求和是不需要的，我们在枚举下标 j 的时候已经能 O(1) 求出[j,i] 的子数组之
     *
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he
     * -wei-kde-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i<nums.length ; i++){
            int sum = 0;
            for(int j = i ; j>= 0 ; j--){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}
