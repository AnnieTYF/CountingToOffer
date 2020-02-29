package leecode.Array;

import java.util.Arrays;

public class MergeTwoSortedArray {
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * Note:
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or
     * equal to m + n) to hold additional elements from nums2.
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * Output: [1,2,2,3,5,6]
     */
    /**
     * 解法一：将第二个数组copy到第一个数组中，然后将整个数组排序
     * 时间复杂度 : O((n+m)log(n+m))
     * 空间复杂度 : O(1)
     */
    public  void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    /**
     * 解法二：两个有序数组合并，从前往后两个指针，从头开始
     * 小的元素放到数组中，指针向后移
     * 时间复杂度 : O(n + m)
     * 空间复杂度 : O(m)
     */
    public  void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m+n];
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < m && j < n){
            if(nums1[i] > nums2[j]){
                num[count] = nums2[j];
                j++;
                count++;
            }else{
                num[count] = nums1[i];
                i++;
                count++;
            }
        }
        if(i < m){
            for(;i<m;i++){
                num[count] = nums1[i];
                count++;
            }
        }
        if(j < n){
            for(;j<n;j++){
                num[count] = nums2[j];
                count++;
            }
        }
        //因为最后的结果是看nums1
        System.arraycopy(num,0,nums1,0,m+n);
    }

    /**
     * 解法三：解法二的改进，解法二的时间复杂度已经优化到最好了，剩下的就是优化空间复杂度了
     * 从后往前遍历数组
     * 时间复杂度 : O(n + m)
     * 空间复杂度 : O(1)
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int count = nums1.length-1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[count] = nums1[i];
                i--;
                count--;
            }else{
                nums1[count] = nums2[j];
                j--;
                count--;
            }
        }
        System.arraycopy(nums2,0,nums1,0,j+1);
    }
    public static void main(String args[]){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge3(nums1,3,nums2,3);
    }
}
