import java.util.Scanner;

public class WeiZhong2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        solution(n,m,a,b);
    }
    public static void solution(long n , long m, long a, long b){
        long num = 0;
        if(m%n == 0){
            System.out.println(0);
        }else {
            if (m > n) {
                while (n > 0) {
                    if (m % n == 0) {
                        num = n;
                    }
                    n--;
                }
            } else {
                num = n - m;
            }
            if (a > b) {
                System.out.println(b * num);
            } else {
                System.out.println(a * num);
            }
        }
    }
}

