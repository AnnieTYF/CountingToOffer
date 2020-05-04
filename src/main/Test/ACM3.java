import java.util.Scanner;

public class ACM3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] height = new int[n][n];
        height[0][0] = in.nextInt();
        int count = 0;
        for(int i = 1; i<n;i++){
            for(int j = 0;j<=i;j++){
                int num = in.nextInt();
                if(j == 0){
                    height[i][j] = height[i-1][j] + num;
                }else{
                    height[i][j] = Math.max(height[i-1][j-1],height[i-1][j]) + num;
                }
                count = Math.max(height[i][j],count);
            }
        }
        System.out.println(count);
    }

}
