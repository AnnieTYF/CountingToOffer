package leecode.Array;

import java.util.ArrayList;
import java.util.HashMap;

public class Intersect {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     */
    /**
     * 用hashmap做，因为这道题并不要求交集元素的顺序也一样，只是元素值相同即可
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        ArrayList<Integer> array = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer num : nums1){
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        for(Integer num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                array.add(num);
                int count = map.get(num);
                map.put(num,--count);
            }
        }
        int[] res = new int[array.size()];
        for(int j = 0; j<array.size();j++){
           res[j] =  array.get(j);
        }
        return res;
    }
    public static void main(String args[]) {
        int[] num1 = {3,1,2};
        int[] num2 = {1};
        int[] res = intersect(num1,num2);
        for(Integer num : res){
            System.out.println(num);
        }
    }
}
