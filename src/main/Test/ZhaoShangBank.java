import java.util.ArrayList;
import java.util.Scanner;

public class ZhaoShangBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //有几种颜色
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        //有几组输入数据
        int group = sc.nextInt();
        for(int i = 0; i < group; i++){
            //每种颜色有几只
            ArrayList<Integer> array = new ArrayList<>();
            //有几种颜色
            int color = sc.nextInt();
            for(int j = 0; j < color ; j++){
                int num = sc.nextInt();
                if(num != 0){
                    array.add(num);
                }
            }
            total.add(array);
        }
        for(int i = 0 ; i<group;i++){
            solution(total.get(i));

        }
    }
    public static void solution(ArrayList<Integer> array){
         boolean flag = false;
         for(Integer num : array){
            if(num >= 2){
                flag = true;
            }
         }
         if(flag){
             System.out.println(array.size()+1);
         }else{
             System.out.println(-1);
         }
    }
}
