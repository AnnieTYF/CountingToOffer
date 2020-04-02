import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BaiDu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] array = new long[n];
        for(int i = 0; i<n;i++){
            long element = in.nextLong();
            array [i] = element;
        }
        solution(array,n);
    }
    public static void solution(long[] array,int n){
        long count = 0;
        Arrays.sort(array);
        while(array[array.length-1] >= n){
             long time = (long) Math.floor(array[array.length-1]/n);
             array[array.length-1] = array[array.length-1] - n*time;
             for(int i = 0; i<array.length-1;i++){
                 array[i] = array[i] + time;
             }
             Arrays.sort(array);
             count += time;
        }

        System.out.print(count);
    }

}
