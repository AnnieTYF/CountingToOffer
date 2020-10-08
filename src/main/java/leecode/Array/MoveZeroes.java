package leecode.Array;

public class MoveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 1;
        while(fast < nums.length){
            if(nums[slow] != 0){
                slow++;
            } else {
                if(nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                    slow++;
                }
            }
            fast++;
        }
    }

    public int removeElement(int[] nums, int val) {
       int slow = 0;
       int fast = 0;
       while(fast<nums.length){
           if(fast != val){
               nums[slow] = nums[fast];
               slow++;
           }
           fast++;
       }
       return slow+1;
    }
}
