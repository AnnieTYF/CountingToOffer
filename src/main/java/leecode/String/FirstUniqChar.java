package leecode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1
 */
public class FirstUniqChar {
    /**
     * 可以用hashmap做，也可以用数组做，因为一共26个字符
     * 先用数组,但是他要求有序，因为要找第一个,返回的是位置[有序不用强加在hashmap上，可以再遍历一遍字符串]
     * 所以也可以用数组下标表示字符
     * 45 ms
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
         HashMap<Character,Integer> map = new HashMap();
        for(int i = 0 ; i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),0);
            }else{
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i),++count);
            }
        }
                for(int j = 0; j <s.length();j++){
                    if(map.get(s.charAt(j)) == 0){
                        return j;
                    }
                }
        return -1;
    }

    /**
     * 使用数组优化速度
     * 7m
     * @param s
     * @return
     */
    public static int firstUniqChar2(String s) {
            int[] count = new int[26];
            for(int i = 0 ; i<s.length();i++){
                count[s.charAt(i)-'a']++;
            }
            for(int j = 0; j <s.length();j++){
                if(count[s.charAt(j)-'a'] == 0){
                    return j;
                }
            }
        return -1;
    }
    public static void main(String args[])
    {
        String s = "dddccdbba";
        System.out.print(firstUniqChar(s));
    }
}
