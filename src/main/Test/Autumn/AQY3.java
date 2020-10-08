package Autumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AQY3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");

        int[] nums = new int[str.length];
        for(int i = 0; i<str.length ; i++){
            nums[i] = Integer.valueOf(str[i]);
        }
        List<List<Integer>> res = solution(nums);
        if(res == null){
            System.out.print("");
        }
        for(List<Integer> list : res){
            for(int i = 0; i<list.size() ; i++){
                System.out.print(list.get(i));
                if(i < list.size()-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> solution(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i<nums.length;i++){
            if(nums[i] > 0){
                return res;
            }
            //去重
            if(i >0 && nums[i] == nums[i-1]){
                continue;
            }
            int first = i+1;
            int last = nums.length-1;
            while(first < last){
                int sum = nums[i] + nums[first] + nums[last];
                if(sum < 0){
                    first++;
                }else if(sum > 0){
                    last--;
                }else{
                    res.add(
                            Arrays.asList(nums[i],nums[first],nums[last])
                    );
                    while(first < last && nums[first] == nums[first+1]){
                        first++;
                    }
                    while(first < last && nums[last] == nums[last-1]){
                        first--;
                    }
                    first++;
                    last--;
                }
            }
        }
        return res;
    }
}
