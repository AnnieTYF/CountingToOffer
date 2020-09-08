package leecode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    //解题思路：返回索引，用hashmap
    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i<nums.length;i++){
            int orther = target - nums[i];
            if(map.containsKey(orther) && map.get(orther) != i){
               ans[0] = i;
               ans[1] = map.get(orther);
            }
        }
        return ans;
    }
    //返回值就用双指针
    public int[] twoSum3(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int sum = nums[low] + nums[high];
            if(sum < target){
                low++;

            }else if(sum>target){
                high--;
            }else{
               return new int[]{nums[low],nums[high]};
            }
        }
        return ans;
    }

    public static ArrayList<List<Integer>> twoSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int sum = nums[low] + nums[high];
            // 记录索引 lo 和 hi 最初对应的值
            int left = nums[low];
            int right = nums[high];
            if(sum < target){
                while(low < high && nums[low] == left){
                    low++;
                }
            }else if(sum>target){
                while(low < high && nums[high] == right){
                    high--;
                }
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(nums[low]);
                list.add(nums[high]);
                res.add(list);
                while(low < high && nums[low] == left){
                    low++;
                }
                while(low < high && nums[high] == right){
                    high--;
                }
            }
        }
        return res;
    }

    public static ArrayList<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        int sz = nums.length;
        ArrayList<List<Integer>> res = new ArrayList<>();
        // 至少是 2Sum，且数组大小不应该小于 n
        if (n < 2 || sz < n) return res;
        // 2Sum 是 base case
        if (n == 2) {
            int low = start;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                // 记录索引 lo 和 hi 最初对应的值
                int left = nums[low];
                int right = nums[high];
                if (sum < target) {
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                } else if (sum > target) {
                    while (low < high && nums[high] == right) {
                        high--;
                    }
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    res.add(list);
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                    while (low < high && nums[high] == right) {
                        high--;
                    }
                }
            }
        }else{
            // n > 2 时，递归计算 (n-1)Sum 的结果
            for (int i = start; i < sz; i++) {
                ArrayList<List<Integer>>
                        sub = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer>  arr : sub) {
                    // (n-1)Sum 加上 nums[i] 就是 nSum
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3};

        System.out.println(twoSum( nums, 4));
    }
}
