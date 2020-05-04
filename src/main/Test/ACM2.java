import java.lang.reflect.Array;
import java.rmi.activation.ActivationGroup_Stub;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ACM2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for(int i = 0; i<n;i++){
            int num = in.nextInt();
            height[i] = num;
        }
        solution(height,k);
    }
    public static void solution(int[] data,int k){
        Arrays.sort(data);
        int sum = 0;
        int middle = data[data.length / 2];
        int midCount = middleCount(data,middle);

       while(midCount < k){
            Arrays.sort(data);
            int temp;
           int max = data[data.length-1];
           int min = data[0];
            if(min == middle && max != middle){
                temp = max;
            }else {
                temp = min;
            }

            sum += Math.abs(temp - middle);
            if(temp < middle){
                data[0] = 2;
            }
            if(temp > middle){
                data[data.length-1] =2;
            }
            midCount++;
        }
        System.out.println(sum);
    }

    public static int middleCount(int[] data , int middle){
        int count = 0;
        for(int i = 0; i<data.length;i++){
            if(data[i] == middle){
                count++;
            }
        }
       return count;
    }
}
