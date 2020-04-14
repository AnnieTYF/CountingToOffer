import java.util.Scanner;

public class WangYiHuYu3 {
    //求全排列乘以权重
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt(); //正整数个数
            int[][] array = new int[n][2];
            for(int j = 0; j<n ; j++){
                int num = sc.nextInt();
                array[j][0] = num;
            }
            for(int k = 0; k<n;k++){
                int num = sc.nextInt();
                array[k][1] = num;
            }
            solution(array);
        }
    }
    //按权重排序,权重最下的启动顺序最大
    public static void solution(int[][] array){

        int sum = (array.length-1)*array[0][1];
        for(int i = 1; i<array.length;i++){
            sum += array[i][1];
        }
        System.out.println(sum);
    }

}
