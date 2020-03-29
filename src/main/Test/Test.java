import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    //动态规划，我不是很会用拥戴规划求概率题
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        solution(n,m) ;
    }
    public static void solution(Integer n, Integer m) {
        int total = n + m;
        List<Double> aWin = new ArrayList<>();

        Double notWin = 1.0;
        while(total > 0){
            //A获胜
            aWin.add(notWin * (double)(n/total));
            total--;
            //B也没获胜，且B丢掉的不是中奖票
            notWin = (double) m/(total-1)+ (double)((m-1)/(total-2));
            total = total-2;
        }
        Double sum = 0.0;
       for(Double num : aWin){
           sum += num;
       }
       DecimalFormat df = new DecimalFormat("#.0000");
       System.out.print(df.format(sum));
    }
}
