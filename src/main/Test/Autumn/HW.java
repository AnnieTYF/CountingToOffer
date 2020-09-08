package Autumn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HW {

    /**
     * Hashmap
     */
    public static String solution(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        char[] ch = str.toCharArray();
        for(int i = 0; i<str.length();i++){
            //ch 可能要改成String
             if(map.containsKey(ch[i])){
                 int count = map.get(ch[i]);
                 map.put(ch[i],++count);
             }else{
                 map.put(ch[i],1);
             }
        }
        //重组,将字符串输出
        String[] strs = new String[map.size()];
        int count = 0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            StringBuilder temp = new StringBuilder();
            char c = entry.getKey();
            for(int i = 0; i < entry.getValue() ; i++) {
                temp.append(c);
            }
            strs[count] = temp.toString();
            count++;
        }
        //按照字符串的长短对数组进行排序
        Arrays.sort(strs);
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
       String[] strs = new String[3];
       strs[0] = "tree";
       strs[1] = "cccaaa";
       strs[2] = "Aabb";
       for(String str : strs){
           System.out.println(solution(str));
       }
    }
}
