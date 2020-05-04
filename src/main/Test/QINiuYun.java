import java.util.Arrays;
import java.util.Scanner;

public class QINiuYun {

    public static int find(int[] matrix, int now){
        if(matrix[now] == now){
            return now;
        }
        int fx = find(matrix,matrix[now]);
        matrix[now] = fx;
        return fx;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int point = in.nextInt();
        int line = in.nextInt();
        int[] matrix = new int[point+1];
        for(int i = 1; i<=point;i++){
            matrix[i] = i;
        }
       for(int i = 1 ; i<=line;i++){
           int x = in.nextInt();
           int y = in.nextInt();
           int fx = find(matrix,x);
           int fy = find(matrix,y);
           matrix[fx] = fy;
       }
       boolean flag = true;
       int p = find(matrix,1);
       for(int i = 1; i<= point;i++){
           if(find(matrix,i) != p){
               flag = false;
               break;
           }
       }
       if(flag){
           System.out.println("YES");
       }else{
           System.out.println("NO");
       }
    }
}
