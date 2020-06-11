package leecode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
         Map<Character,Integer> need = new HashMap<>();
         Map<Character,Integer> window = new HashMap<>();

         for(char c : s1.toCharArray()){
             if(need.containsKey(c)){
                 int count = need.get(c);
                 need.put(c,++count);
             }else{
                 need.put(c,1);
             }
         }
         int left = 0;
         int right = 0;
         int valid = 0;//有效字符

         while(right < s2.length()){
             char c = s2.charAt(right);
             right++;
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

             //窗口暂停扩大的条件
             while(right - left >= s1.length()){
                 // 在这里判断是否找到了合法的子串
                 if(valid == need.size()){
                     return true;
                 }
                 char d = s2.charAt(left);
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
         return false;
    }

    public static void main(String args[]) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

}
