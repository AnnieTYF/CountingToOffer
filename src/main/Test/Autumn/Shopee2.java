package Autumn;

import java.util.Comparator;
import java.util.Scanner;

public class Shopee2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String origin  = in.nextLine();
        char[] nums = origin.toCharArray();
        String str = solution(nums);
        if(str.charAt(0) == '0' || str.compareTo(origin) >=0){
            System.out.println(0);
        }else{
            System.out.println(str );
        }
    }

    public static String solution(char[] nums){
        int i = nums.length-2;
        while(i >=0 && nums[i+1] >= nums[i]){
            i--;
        }
        if(i >= 0){
            int j = nums.length-1;
            while(j >= 0 && nums[j] >= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
       return String.valueOf(nums);
    }

    public static void reverse(char[] nums, int start){
        int i = start;
        int j = nums.length-1;
        while(i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public static void swap(char[] nums, int i, int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
