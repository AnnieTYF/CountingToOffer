import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        int[][] path = new int[n][n];
        int[] w = new int[n];
        for(int i = 0; i<n ;i++){
            num[i] = in.nextInt();
        }
        for(int k = 0; k<n ;k++){
            int i = in.nextInt();
             w[i-1] = in.nextInt();
            for(int m = 0; m < num[i];m++){
                int j = in.nextInt();
                path[i-1][j-1] = 1;
            }
        }
        solution(path,w);
    }

    public static void solution(int[][] path,int[] w){

    }
}
