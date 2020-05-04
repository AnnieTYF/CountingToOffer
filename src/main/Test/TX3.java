import java.util.Scanner;

public class TX3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i<n;i++){
            int num = in.nextInt();
            a[i] = num;
        }
        for(int j = 0; j<n;j++){
            int num = in.nextInt();
            b[j] = num;
        }
        solution(a,b);
    }
    public static void solution(int[] a, int[] b){
        int count = 0;
        for(int i = 0; i<a.length;i++){
            for(int j = 0; j<b.length;j++){

            }
        }
        System.out.print(1);
    }

}
