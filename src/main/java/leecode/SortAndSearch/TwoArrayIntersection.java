package leecode.SortAndSearch;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 */
public class TwoArrayIntersection {
    /**
     * 想法一：排序 + 双指针
     * 时间复杂度：O(nlogn)
     * 因为使用了排序，所以时间复杂度是O(nlogn)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                    set.add(nums1[i]);
               i++;
               j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for(int num : set){
            res[index++] = num;
        }
        return res;
    }

    /**
     * 方法二：排序 + 二分查找
     * 方法三：用hash表存储，时间复杂度是O(n)，因为不需要排序，空间复杂度是O(N)
     * @return
     */


}
