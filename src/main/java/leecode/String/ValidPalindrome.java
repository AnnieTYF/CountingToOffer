package leecode.String;

import java.util.HashMap;
import java.util.Map;

public class ValidPalindrome {

    /**
     * 验证回文字符串 Ⅱ
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * https://leetcode-cn.com/problems/valid-palindrome-ii/
     */
    /**
     * 第一个想法用 hashmap，允许最多有两个不一样的奇数，这样可以删除一个还是回文串
     */
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] chs = s.toCharArray();
        while(i<j){
            if(chs[i] == chs[j]){
                i++;
                j--;
            }else{
                //判断字串是否是回文串 i+1 == j || i == j-1
                boolean flag1 = true;
                boolean flag2 = true;
                for(int low = i+1 ,high = j ;low<high; low++,high--){
                    if(chs[low] != chs[high]){
                        flag1 = false;
                        break;
                    }
                }
                for(int low = i ,high = j-1 ;low<high; low++,high--){
                    if(chs[low] != chs[high]){
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String s = "eeccccbebaeeabebccceea";
        System.out.println(validPalindrome(s));
    }
}
