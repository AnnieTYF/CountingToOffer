package leecode.String;

public class isStringPalindrome {
    /**
     * 验证回文串
     * Given a string, determine if it is a palindrome, considering only
     * alphanumeric characters and ignoring cases.
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     * 例如：
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     * Input: "race a car"
     * Output: false
     */

    /**
     * 想法一：字符串，只保留数字和字母，从前往后，从后往前判断，两个指针
     * 注意Character.isLetterOrDigit方法的应用
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
           int i = 0;
           int j = s.length()-1;
           while(i<j){
               if (!Character.isLetterOrDigit(s.charAt(i))) {
                   i++;
               } else if(!Character.isLetterOrDigit(s.charAt(j))) {
                   j--;
                   //这里忽略大小写判断的方法也很巧，借鉴了string.equalsIgnoreCase(s)的底层源码
               } else if(Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))){
                   return false;
               }else{
                   i++;
                   j--;
               }
           }
         return true;
    }
    public static void main(String args[])
    {
        String s = "race a car";
        System.out.println(isPalindrome(s));
        String  a="ABCD";
        String  b="abcd";
        System.out.println(a.equalsIgnoreCase(b));
    }
}
