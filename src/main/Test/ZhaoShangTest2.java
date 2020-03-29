import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ZhaoShangTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //有几种颜色
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        //有几组输入数据
        int group = sc.nextInt();
        for(int i = 0; i < group; i++){
            //长度
            ArrayList<Integer> lengthArray = new ArrayList<>();
            //有几个木棍
            int count = sc.nextInt();
            for(int j = 0; j < count ; j++){
                int length = sc.nextInt();
                lengthArray.add(length);
            }
            total.add(lengthArray);
            //长度
            ArrayList<Integer> wideArray = new ArrayList<>();
            for(int j = 0; j < count ; j++){
                int wide = sc.nextInt();
                wideArray.add(wide);
            }
            total.add( wideArray);
        }
        int n = 0;
        for(int i = 0 ; i<group;i++){
            solution(total.get(n),total.get(++n));
            n++;
        }

    }
    public static void solution(ArrayList<Integer> length ,ArrayList<Integer> wide){
        HashMap<Integer,Integer> direct = new HashMap<>();
        for(int i = 0; i<length.size();i++){
            //长宽对应
            direct.put(length.get(i),wide.get(i));
        }
        Collections.sort(length);
        int cost = 1;
        //长度排序后
        for(int i = 1; i<length.size();i++){
            if(direct.get(length.get(i)) < direct.get(length.get(i-1))){
               cost++;
            }
        }
        System.out.println(cost );
    }
}
