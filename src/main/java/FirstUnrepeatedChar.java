import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUnrepeatedChar {
    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
     * 如果没有则返回 -1（需要区分大小写）.
     */

    /**
     * 解法一：运用HashMap，利用每个字母的ASCII码作hash来作为数组的index，统计每个字母出现的次数
     * 注意点，这道题不能用arrayList，然后remove(char)
     * 因为虽然remove(int index) remove(Object o)有两个方法，但是字符在这里默认转换成它的ASCII码值
     * 所以remove(d) 等价于 remove(100)会发生数组越界报错
     * 44ms
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar(String str) {
        if(str == null){
            return -1;
        }
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        int count = 0;
        for(int i = 0 ; i < str.length();i++){
            if(map.containsKey(str.charAt(i))){
                count = map.get(str.charAt(i));
                map.put(str.charAt(i),++count);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        for(int j = 0;j < str.length();j++){
            if(map.get(str.charAt(j)) == 1){
                return j;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        String str = "abcdebcd";
        System.out.println(FirstNotRepeatingChar(str));
    }
}
