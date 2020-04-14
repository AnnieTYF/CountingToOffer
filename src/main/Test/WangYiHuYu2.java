import java.util.ArrayList;
import java.util.Scanner;

public class WangYiHuYu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int n = sc.nextInt(); //正整数个数
            int m = sc.nextInt();
            for(int j = 0; j<m ; j++){
                ArrayList<Integer> array = new ArrayList<>();
                int op = sc.nextInt();
                if(op == 1){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    array.add(x);
                    array.add(y);
                }else if(op == 2){
                    int x = sc.nextInt();
                    if( (array.size() > 1) && (array.contains(x))) {
                        array.remove(x);
                    }
                }else if(op == 3){
                    int x = sc.nextInt();
                    if(array.contains(x)){
                        System.out.println(array.size());
                    }
                }
            }
        }
    }

    /**
     * 刀砍的范围是一个圆
     */
    public static void solution(int[][] area , int len , int m, int x , int y){

    }
}
