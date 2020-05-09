import java.util.ArrayList;
import java.util.Scanner;

public class QWE {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum1 = 0;
        int sum2 = 0;
        int count = 0;
        int[] num = new int[n];
       for(int i =0; i<n ; i++){
           int temp = in.nextInt();
           if(temp % 5 == 0){
               sum1 += temp;
           }else if(temp%3 == 0){
               sum2 += temp;
           }else{
               num[count++] = temp;
           }
       }
       int sum = Math.abs(sum1-sum2);
        System.out.println(solution(count,num,sum));
    }
    public static boolean solution(int count, int[] num, int sum) {
        if (count == 0) {
            return sum == 0;
        }
        return false;
    }
   /* public static boolean solution(int i, int count, int[] num, int res,int sum){
      if(count == 0){
          return sum == 0;
      }else{
          return
      }
    }*/
}
