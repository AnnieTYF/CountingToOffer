import java.util.Arrays;
import java.util.Scanner;

public class ALi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int factoryNum = in.nextInt();
        int day =  in.nextInt();
        int increment = in.nextInt();
        long[] chicken = new long[factoryNum];
        for(int i = 0; i<factoryNum; i++){
            int num =in.nextInt();
            chicken[i] = num;
        }
        solution(chicken,day,increment);
    }
    public static void solution(long[] chicken,int day, int increment){
        long total = 0;
        for(int i = 0 ;i<day ;i++){
            for(int j = 0 ; j<chicken.length;j++){
                chicken[j] += increment;
            }
            Arrays.sort(chicken);
            chicken[chicken.length-1] = chicken[chicken.length-1]/2;
        }
        for(int j = 0 ; j<chicken.length;j++){
            total += chicken[j];
        }
        System.out.print(total);
    }
}
