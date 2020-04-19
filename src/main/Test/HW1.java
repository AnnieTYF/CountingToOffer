import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] name = s.split(",");
        System.out.println(solution(name));
    }

    public static String solution(String[] name){
       Arrays.sort(name);
        HashMap<String,Integer> map = new HashMap<>();
        //找出每人的投票数
        for(int i = 0; i < name.length ; i++){
            char[] ch = name[i].toCharArray();
            for(int j = 0; j<ch.length;j++){
                //判断是否是合法输入
                if(!Character.isLetter(ch[j])){
                    return "error.0001";
                }
                if(j == 0 && !Character.isUpperCase(ch[j])){
                    return "error.0001";
                }
                if(j != 0 && !Character.isLowerCase(ch[j])){
                    return "error.0001";
                }
            }
            if(!map.containsKey(name[i])){
                map.put(name[i],1);
            }else{
                int count = map.get(name[i]);
                map.put(name[i],++count);
            }
        }
        int count = 0;
        String res = name[0];
        for(int i = 0; i<name.length;i++){
            if(count < map.get(name[i])){
                count = map.get(name[i]);
                res = name[i];
            }
        }
        return res;
    }

}
