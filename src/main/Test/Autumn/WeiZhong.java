package Autumn;

import java.util.Arrays;
import java.util.Scanner;

public class WeiZhong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        long[] nums = new long[n];
        for(int i = 0; i<n ; i++){
            nums[i] = sc.nextLong();
        }
        for(int i = 0; i<q ; i++){
            long num = sc.nextLong();
            if(num<=nums[0]){
                System.out.println(nums[0]);
            }else if(num >= nums[nums.length-1]){
                System.out.println(nums[nums.length-1]);
            }else{
                System.out.println(nums[solution(num,nums)]);
            }
        }
    }

    public static int solution(long num, long[] nums){
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while(left<= right){
            int mid = left+(right-left)/2;
            if(nums[mid] == num){
                return mid;
            }else if(nums[mid] < num){
                left = mid+1;
            }else if(nums[mid] > num){
                right = mid-1;
            }
        }
        if(left<nums.length){
            return left;
        }else{
            return nums.length-1;
        }
    }
}
