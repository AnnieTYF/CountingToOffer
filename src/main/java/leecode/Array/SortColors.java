package leecode.Array;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int left = 0;
        int right = nums.length-1;
        int cur = 0;
         //以1为基准，三路快排
        while(cur <= right){
            if(nums[cur] == 0){
               int temp = nums[left];
               nums[left] = nums[cur];
               nums[cur] = temp ;
               ++left;
               /*
               Curr左边的，一定是都扫描过的，所以只有两种情况：
               1. 0 和 1 若交换后，curr当前值为0，那么此时0的右边界一定大于curr，所以curr要加1
               2. 若交换后，curr当前值为1，那么此时curr肯定是要下移一步的
               所以，无论如何，只要和左边交换，p0是一定要移动1次的
               综上，这两种的处理方式其实是一样的，所以就统一成“和左边交换，都右移1”
                */
                ++cur;
            }else if(nums[cur] == 2){
                //curr位置是2时，交换后，curr不能移动，因为一移动，没法保证交换过来的是0/1；
                // 所以这里不移动；这时状态也维持住了
                int temp = nums[right];
                nums[right] = nums[cur] ;
                nums[cur]  = temp ;
                --right;
            }
                cur++;

        }
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors( nums);
    }
}
