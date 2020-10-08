package Autumn;

import java.util.Scanner;

public class BaiDu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for(int i = 0; i<n ; i++){
            nums[i] = sc.nextLong();
        }
        System.out.println(solution(nums));
    }

    public static int solution(long[] nums){
        if(nums.length < 3){
            return 0;
        }
        int count = 0;
        for(int i = 0; i<nums.length-2;i++){
            for(int j = i+1; j<nums.length-1;j++){
                if(nums[i] <= nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[j] <= nums[k]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
