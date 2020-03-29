import java.util.HashMap;
import java.util.Scanner;

public class MeiTuanTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String data2 = sc.nextLine();
        String[] replace = data2.split(" ");
        solution(data,replace);
    }
    public static void solution(String data, String[] replace){
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean flag = false;
        if(data.charAt(0) == '-'){
            flag = true;
        }
        if(flag){
            for (int i = 1; i < replace.length; i++) {
                map.put(i, Integer.parseInt(replace[i-1]));
            }
        }else {
            for (int i = 0; i < replace.length; i++) {
                map.put(i, Integer.parseInt(replace[i]));
            }
        }
        //负数
        if(flag){
            System.out.print(data.charAt(0));
            for(int j = 1;j<data.length();j++){
                System.out.print(map.get((data.charAt(j)-'0')));
            }
        }else{
            for(int j = 0;j<data.length();j++){
                System.out.print(map.get((data.charAt(j)-'0')));
            }
        }
    }
}
