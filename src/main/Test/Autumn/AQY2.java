package Autumn;

import java.util.HashMap;
import java.util.Scanner;

public class AQY2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");

        int[] nums = new int[str.length];
        for(int i = 0; i<str.length ; i++){
            nums[i] = Integer.valueOf(str[i]);
        }
        System.out.print(solution(nums));
    }

    public static int solution(int[] nums){
       if(nums.length == 0){
           return 0;
       }
       if(nums.length == 1){
           return nums[0];
       }
       int flag = 0;
       int temp = nums[0];
       for(int num : nums){
           if(flag == 0){
               temp = num;
               flag++;
           }else{
               flag += (temp == num)?1:-1;
           }
       }
       return temp;
    }
}
