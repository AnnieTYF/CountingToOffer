import java.util.Scanner;

public class TX5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int i = 0; i<q;i++){
            long x = in.nextLong();
            int k = in.nextInt();
            int depth = solution(x);
            if( k >= depth){
               System.out.println(-1);
            }else{
                int count = depth -k;
                while(count > 0){
                    x = x>>1;
                    --count;
                }
                System.out.println(x);
            }
        }
    }

    public static int solution(long x){
          int res = 0;
          while(x != 0){
              res++;
              x = x>>1;
          }
          return res;
    }
}
