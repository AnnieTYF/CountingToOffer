package leecode.Array;

public class FindMin {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        if (nums[high] > nums[0]) {
            return nums[0];
        }
        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[low]){
                low = mid+1;
            }else if(nums[mid] < nums[high]){
                high = mid;
            }else if(nums[mid] == nums[high]){
                high = high -1;
            }
        }
        return nums[low];
    }
}
