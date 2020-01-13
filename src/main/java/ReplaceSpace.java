public class ReplaceSpace {

    public static void main(String args[]){
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(str));
    }

    /**
     * 暴力循环破解法
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        String string = new String(str);
        for(int i=0;i<str.length();i++){
            if(string.charAt(i) == 32){
                string = string.replace(" ","%20");
            }
        }
        //其实这里不需要循环，直接replaceAll就好
        return string;
    }

    /**
     * 解法一：直接用JAVA自带的函数
     *\s是正则中的空格，还有一个、是转义字符
     * @param str
     * @return
     */
    public String replaceSpace2(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }

    /**
     * 解法二：
     * 这道题如果不用replace函数，那么他的解题思路就是怎么替换移动的次数最少
     * 一般采用的方法是将字符串从前往后遍历一遍，记录空格的数量，先计算替换后的字符串需要多大的空间，并对原字符串空间进行扩容
     * 再从后往前替换字符串的话，每个字符串只需要移动一次；
     * 如果从前往后，每个字符串需要多次移动，效率较低
     */

    /**
     * 解法三：开辟一个新的字符串，遇到空格就换成添加“%20”
     * 调用string 的append 方法
     */
}
