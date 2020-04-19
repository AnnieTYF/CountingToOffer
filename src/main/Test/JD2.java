import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JD2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[][] cus = new int[num][2];
        for(int i = 0; i<num ; i++){
            cus[0][0] = in.nextInt();
            cus[0][1] = in.nextInt();
        }
        System.out.println(solution(cus));

    }
    public static int solution(int[][] cus){
        int len = cus.length;
        if(len < 2){
            return len;
        }
        Arrays.sort(cus, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });
        int[] first = new int[len];
        for(int i = 0; i<len;i++){
            first[i] = cus[i][1];
        }
        int[]dp = new int[len];
        int end = 0;
        for(int num : first){
            int i = Arrays.binarySearch(dp,0,end,num);
            if(i < 0){
                i = -(i+1);
            }
            dp[i] = num;
            if(i == end){
                end++;
            }
        }
        return end;
    }
}
