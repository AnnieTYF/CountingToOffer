import java.util.HashMap;
import java.util.LinkedList;

public class LeftRotatingStringArray {
    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），用字符串模拟这个指令的运算结果。
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
     */

    /**
     * 解法一:取子串拼接字符串
     * 21ms
     * @param str
     * @param n
     * @return
     */
    public  static String LeftRotateString(String str,int n) {
        if(str.length() <= n){
            return str;
        }
        String s1 = str.substring(0,n);
        String s2 = str.substring(n);
        return  s2+s1;
    }

    /**
     * 解法二：这道题考的是字符串的翻转,
     * 把字符串分为两部分，例如，字符序列S=”abcXYZdef”，X=abc,Y=XYZdef
     * 原理 YX = (X^T Y^T)^T
     *21ms
     */
    public static String LeftRotateString2(String str, int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n) {
            return "";
        }
        reverse(chars, 0, n - 1); //X^T , X的倒置
        reverse(chars, n, chars.length - 1); //Y^T
        reverse(chars, 0, chars.length - 1); //(X^T Y^T)^T

        return new String(chars);
    }

    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]){
        String str = "abcdefg";
        System.out.println(LeftRotateString2( str,3));
    }
}
