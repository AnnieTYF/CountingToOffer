package leecode.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * 输入:
 * s = "aaabb", k = 3
 * 输出:
 * 3
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 */
public class LongestSubstring {
    public static int longestSubstring(String s, int k) {
        int len=s.length();
        if(len<k)return 0;

    //    return solution(s.toCharArray(), k, 0, len);
        HashMap<Character,Integer> map = new HashMap<>();
        //记录字符串的终点位置，当有>=k的字符串出现时，置1
        int[] dp = new int[s.length()];
        Arrays.fill(dp,0);
        //记录每个字符有多少个
        for(int i = 0 ; i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i),++count);
            }
            if(map.get(s.charAt(i)) >= k){
                dp[i] = 1;
            }
        }
        int res = 0;
        for(int i = dp.length-1; i>=0;i--){
            if(dp[i] == 1){
                for(int j = i ; j>=0;j--){
                    if(map.get(s.charAt(j)) < k){
                        if(i-j >= k){
                            res = Math.max(res,i-j);
                        }
                        break;
                    }
                    if((i-j) >= k){
                        res = Math.max(res,(i-j)+1);
                    }
                }
            }
        }
       return res;
    }
  //递归 + 分治
    public static int solution(char[] chars, int k, int p1, int len){
       return 0;
    }
    public static void main(String[] args) {
        String s = "ababacb";
        System.out.println(longestSubstring( s, 3));
    }
}
