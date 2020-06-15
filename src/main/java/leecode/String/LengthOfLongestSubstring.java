package leecode.String;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {
    /**
     * 双指针法
     * 时间复杂度：O(n^2)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        ArrayList<Character> array = new ArrayList<>();
        int length = 1;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(!array.contains(s.charAt(right))){
                array.add(s.charAt(right));
                right++;
            }else{
                length = Math.max(length,array.size());
                //有重复的，就从之前重复的字符开始
                for(int i = 0; i<array.size();i++){
                    if(array.get(i) == s.charAt(right)){
                        left += (i+1);
                        right = left;
                        break;
                    }
                }
                array = new ArrayList<>();
            }
        }
        return Math.max(length,array.size());
    }

    /**
     * 优化，使用哈希表记录每个字符的下一个索引，就不用再遍历了
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int length = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                //由于重复的坐标不知道在start的前方还是后方，所以要取个最大值
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            length = Math.max(length,right-left+1);
            map.put(s.charAt(right),right);
            right++;
        }
        return length;
    }

    /**
     * 滑动窗口法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(window.containsKey(c)){
                int count = window.get(c);
                window.put(c,++count);
            }else{
                window.put(c,1);
            }
            //如果出现重复字符，向左缩减窗口,直到没有和c重复的字符
            while(window.get(c) > 1){
              char d = s.charAt(left);
              left++;
                if(window.containsKey(d)){
                    int count = window.get(d);
                    window.put(d,--count);
                }
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
