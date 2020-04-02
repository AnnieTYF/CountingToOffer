import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ALi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] seq = new int[n];
        for(int i = 0; i<n; i++){
            int num =in.nextInt();
            seq[i] = num;
        }
        solution(seq);
    }
    public static void solution(int[] seq){
        //记录有几种最大期望值，每一种有几个
        HashMap<Integer,Integer> count = new HashMap<>();
        Arrays.sort(seq);
        sequence(seq,0,0);

    }
    ArrayList<ArrayList<Integer>> array = new ArrayList<>();
    //求数组的所有连续子序列
    public static void sequence(int[] seq , int left,int right){
        ArrayList<Integer> list = new ArrayList<>();
        //先定最左边
        list.add(seq[left]);
        //右边是一个递增序列，增到哪里，看从哪里开始
          for(int i = right ; i < seq.length ; i++){

          }
          sequence(seq,left,right++);
    }
}
