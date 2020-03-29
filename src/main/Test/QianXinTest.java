import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QianXinTest {

    private static int result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int[] nums = {5,3,3,2,4,1};
        int[] money = {1,2,2,2,5,3};
        solution(nums,money,0,total,0);
        System.out.print(result);
   /* 解法二：
      int count = 0;
       for(int i = 0 ; i<6;i++){
           if(total >= money[i]){
               total -= money[i];
               count += nums[i];
           }
       }
       System.out.print(count);*/
    }
    public static void solution(int[] nums,int[] money,int depth,int total,int count){
        result = Math.max(result,count);
        for(int i = depth ; i<money.length;i++){
            if(total < money[i]){
                break;
            }
            solution(nums,money,i+1,total-money[i],count + nums[i]);
        }
    }
}
