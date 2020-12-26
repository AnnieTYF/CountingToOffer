import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class ACM1 {
    public static void main(String[] args) {
        System.out.println(solution(2));
    }
    public static int solution(int i){
       int res = 0;
       switch(i){
           case 1:
               res=res+i;
           case 2:
               res=res+i*2;
           case 3:
               res = res + i*3;
       }
       return res;
    }
}
