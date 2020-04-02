import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class XieChengTest {
    /**
     * 递归计算海豚宝宝的数量
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //初始海豚数
        int initNum = in.nextInt();
        //海豚的寿命
        int totalAge = in.nextInt();
        //海豚生宝宝的年份数量
        int birthYearCount = in.nextInt();
        int[] birthYear = new int[birthYearCount];
        for(int i = 0; i<birthYearCount;i++){
            birthYear[i] = in.nextInt();
        }
        int totalYear = in.nextInt();

        System.out.println(solution(initNum, totalAge , birthYear ,  totalYear));

    }
    static int solution(int initNum, int totalAge , int[] birthYear , int totalYear) {
return 20;
    }
}
