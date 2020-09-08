package Autumn;

import java.util.ArrayList;
import java.util.Scanner;

public class WY2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //测试数据
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<n;i++){
            //多少物品
            int num = in.nextInt();
            ArrayList<Integer> array = new ArrayList<>();
            for(int j = 0; j<num;j++){
                array.add(in.nextInt());
            }
            list.add(array);
        }
        for(ArrayList<Integer> a : list){
            System.out.println(partition(a));
        }
    }

    public static Integer partition(ArrayList<Integer> array){
        int ans = 0;
         int sum = 0;
         int len = array.size();
         for(Integer num : array){
             sum+=num;
         }
        int total = sum/2;
         boolean[] dp = new boolean[total+1];
         dp[0] = true;
         for(int i = 0; i<len;i++){
             for(int j = total; j>=0;j--){
                 if(j - array.get(i) >= 0){
                     dp[j] = dp[j] || dp[j-array.get(i)];
                 }
             }
         }
         for(int n = dp.length-1 ; n>=0 ; n--){
             if(dp[n]){
                 ans = n;
                 return n;
             }
         }
         return ans;
    }
}
