package leecode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinWindow {
    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        //用need数组记录T中每个字符出现的次数，window记录每个需要的字符在窗口中的出现次数
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(char c : t.toCharArray()){
            if(need.containsKey(c)){
                int count = need.get(c);
                need.put(c,++count);
            }else{
                need.put(c,1);
            }
        }
        //增加窗口
        int left = 0;
        int right = 0;
        //表示窗口中满足 need 条件的字符个数，如果 valid 和 need.size 的大小相同，则说明窗口已满足条件，已经完全覆盖了串 T
        int valid = 0;
        //记录最小覆盖子串的起始索引及长度
        int start = 0;
        int len = Integer.MAX_VALUE;
        while(right < s.length()){

            char c = s.charAt(right);
            //右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                if(window.containsKey(c)){
                    int count = window.get(c);
                    window.put(c,++count);
                }else{
                    window.put(c,1);
                }
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            //左缩减窗口
            while(valid == need.size()){
                //更新最小覆盖字符串
                if(right-left < len){
                   start = left;
                   len = right-left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    if(window.containsKey(d)){
                        int count = window.get(d);
                        window.put(d,--count);
                    }
                }

            }
        }
        return len == Integer.MAX_VALUE ? "":s.substring(start,start+len);
    }
    public static void main(String args[]) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
