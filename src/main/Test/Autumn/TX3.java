package Autumn;

import java.util.Scanner;

public class TX3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i<t; i++){
            long num = in.nextLong();
            solution(num);
        }
    }

    public static void solution(long value){
          if(value <= 9){
              System.out.println(value);
              return ;
          }
          int size = (value + "").length();
          String resStr = "";
          for(int j = 1; j<size;j++){
              resStr = resStr + "9";
          }
          long a = Long.parseLong(resStr);
          long b = value-a;
          String rs = a+""+b;
          long res = 0;
          char[] ch = rs.toCharArray();
          for(int j = 0; j<ch.length ; j++){
              res = res + ch[j] - '0';
          }
          System.out.println(res);
    }
}
