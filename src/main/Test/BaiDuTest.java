
import java.util.Scanner;

public class BaiDuTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solution(n);
    }
    public static void solution(long n){
        // n , n-1 的最大公约数 1
        System.out.print(n*(n-1) -1);
    }

    //最大公倍数
    public static int MaxCommonNum(int a, int b){
        if(a == b){
            return a;
        }
        if(a>b){
            a -= b;
        }else{
            b -= a;
        }
        return MaxCommonNum(a,b);
    }
    //最小公约数
    public static int MinCommonNum(int a, int b){
        return (a * b)/MaxCommonNum(a,b);
    }
}
