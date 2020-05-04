package leecode.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * 输入:
 * s = "aaabb", k = 3
 * 输出:
 * 3
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 */
public class LongestSubstring {
    /**
     * 递归 + 分治
     * 假设S[mid]对应的字母出现次数小于k。那么包含S[mid]的子串显然不可能符合题目要求
     * 所以我们就以mid为界限，分别再递归两边的字符串
     * 超时
     * @param s
     * @param k
     * @return
     */
    public static int longestSubstring(String s, int k) {
        int len=s.length();
        if(len == 0 || len<k)return 0;
        if (k < 2) return len;
        return solution(s,k,0,s.length());
    }
    //递归 + 分治
    public static int solution(String s, int k, int start, int end){
        if(end - start < k){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        //记录每个字符有多少个
        for(int i = start ; i<end;i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i),++count);
            }
        }
        for(int i = start ; i<end;i++){
            if(map.get(s.charAt(i)) < k){
                return Math.max(solution(s,k,start,i),solution(s,k,i+1,end));
            }
        }
        return end-start;
    }

    /**
     * 优化：
     * 递归拆分子串，分治。先统计出每个字符出现的频次，
     * 维护一对双指针，从首尾开始统计，从首尾往中间排除，
     * 如果出现次数小于k则不可能出现在最终子串中，排除并挪动指针，然后得到临时子串，
     * 依次从头遍历，一旦发现出现频次小于k的字符，以该字符为分割线，分别递归求其最大值返回
     */
    public static int longestSubstring2(String s, int k) {
        int len=s.length();
        if(len == 0 || len<k)return 0;
        if (k < 2) return len;
        return solution2(s.toCharArray(),k,0,s.length());
    }
    public static int solution2(char[] chars, int k, int p1, int p2){
        if(p2 - p1  < k){
            return 0;
        }
        //记录每个字符有多少个
        int[] times = new int[26];
        for(int i = p1 ; i<p2;i++){
            ++times[chars[i] - 'a'];
        }
        while(p2-p1 >= k && times[chars[p1] - 'a'] < k){
            ++p1;
        }
        while(p2-p1 >= k && times[chars[p2-1] - 'a'] < k){
            --p2;
        }
        if (p2 - p1  < k) return 0;
        //  得到临时子串，再递归处理
        for(int i = p1 ; i<p2;i++){
            if(times[chars[i] - 'a'] < k){
                return Math.max(solution2(chars,k,p1,i),solution2(chars,k,i+1,p2));
            }
        }
        return p2-p1;
    }
    public static void main(String[] args) {
        String s = "aaabbb";
        System.out.println(longestSubstring( s, 3));
    }
}
