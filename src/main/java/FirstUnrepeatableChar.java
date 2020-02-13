import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUnrepeatableChar {
    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     * 如果当前字符流没有存在出现一次的字符，返回#字符。
     */
    //Insert one char from stringstream
    /**
     * 解法一：
     * 为什么不用hashmap，因为hashmap不是按照输入顺序存储的
     * 它是按照字符大小顺序存储的，就回导致输出结果是“ggg#le”，因为e<l所以e在前面
     * 但是答案应该是“ggg#ll”
     * 20ms
     */
    static LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
    public static void Insert(char ch)
    {
          int count;
          if(!map.containsKey(ch)){
              map.put(ch,1);
          }else{
              count = map.get(ch);
              map.put(ch,++count);
          }
        System.out.println(FirstAppearingOnce());
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return '#';
    }
    public static void main(String args[]){
        String str= "google";
        char[] ch = str.toCharArray();
        for(int i = 0; i<ch.length;i++){
            Insert(ch[i]);
        }
    }
}
