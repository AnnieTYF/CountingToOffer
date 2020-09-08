package Autumn;

import java.util.Scanner;

public class BaiDu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solution(n,m,0,0));
    }

    public static int solution(int n , int m, int pre1, int pre2){
          if(n == 1){
              return 1;
          }
          if(n == 2){
              return 2;
          }
          int res = 0;
          int preVal = 1;
          for(int i = 2; i<= m ; i++){
              if(i == pre1 || i == pre2){
                  continue;
              }
              res = 2 * preVal;
              preVal = res;
              pre1 = pre2;
              pre2 = i;
          }
          return res;
    }
}
