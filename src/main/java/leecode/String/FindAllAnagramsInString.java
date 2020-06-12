package leecode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 */
public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> need  = new HashMap<>();
        Map<Character,Integer> window  = new HashMap<>();
        for(char c : p.toCharArray()){
            if(need.containsKey(c)){
                int count = need.get(c);
                need.put(c,++count);
            }else{
                need.put(c,1);
            }
        }

        int left = 0;
        int right = 0;
        int vaild = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                if(window.containsKey(c)){
                    int count = window.get(c);
                    window.put(c,++count);
                }else{
                    window.put(c,1);
                }
                if(need.get(c).equals(window.get(c))){
                    vaild++;
                }
            }

            while(right-left >= p.length()){
                if(vaild == need.size()){
                     res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        vaild--;
                    }
                    if(window.containsKey(d)){
                        int count = window.get(d);
                        window.put(d,--count);
                    }
                }
            }
        }
        return res;
    }
}
