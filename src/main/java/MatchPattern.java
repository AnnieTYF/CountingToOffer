public class MatchPattern {
    /**
     *请实现一个函数用来匹配包括'.'和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）。我不是很懂这个
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     *
     * 注意考虑周全，pattern中也可能有".","*"
     * 所以我们在分情况的时候，应该以pattern为准
     */

    /**
     * 链接：https://www.nowcoder
     * .com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c?answerType=1&f
     * =discussion
     * 来源：牛客网
     *
     *  首先，考虑特殊情况：
     *          1>两个字符串都为空，返回true
     *          2>当第一个字符串不空，而第二个字符串空了，返回false（因为这样，就无法
     *             匹配成功了,而如果第一个字符串空了，第二个字符串非空，还是可能匹配成
     *             功的，比如第二个字符串是“a*a*a*a*”,由于‘*’之前的元素可以出现0次，
     *             所以有可能匹配成功）
     *  之后就开始匹配第一个字符，这里有两种可能：匹配成功或匹配失败。但考虑到pattern
     *  下一个字符可能是‘*’， 这里我们分两种情况讨论：pattern下一个字符为‘*’或不为‘*’：
     *   1>pattern下一个字符不为‘*’：这种情况比较简单，直接匹配当前字符。如果
     *     匹配成功，继续匹配下一个；如果匹配失败，直接返回false。注意这里的
     *      “匹配成功”，除了两个字符相同的情况外，还有一种情况，就是pattern的
     *      当前字符为‘.’,同时str的当前字符不为‘\0’。
     *  2>pattern下一个字符为‘*’时，稍微复杂一些，因为‘*’可以代表0个或多个。
     *     这里把这些情况都考虑到：
     *         a>当‘*’匹配0个字符时，str当前字符不变，pattern当前字符后移两位，跳过这个‘*’符号；
     *         b>当‘*’匹配1个或多个时，str当前字符移向下一个，pattern当前字符
     *          不变。（这里匹配1个或多个可以看成一种情况，因为：当匹配一个时，
     *         由于str移到了下一个字符，而pattern字符不变，就回到了上边的情况a；
     *         当匹配多于一个字符时，相当于从str的下一个字符继续开始匹配）
     */

    /**
     * 解题思路：
     * 先看下一个是否是“*”，再看当前是否相等
     * 1.若下一个是"*",分为当前相等和当前不等
     *      1.1：当前相等dp[i][j]=dp[i][j+2] || dp[i+1][j]
     *      1.2：当前不等dp[i][j]=dp[i][j+2]
     * 2.若不是"*",但是当前相等 d[i][j]= dp[i + 1][j + 1];
     * 19ms
     * @param str
     * @param pattern
     * @return
     */
    public static boolean matchDP1(char[] str, char[] pattern) {
        if(str == null || pattern == null)
            return false;
        boolean [][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[str.length][pattern.length] = true;
        //开始循环
        for (int i = str.length; i >= 0; i--) {//外循环：从空串开始匹配
            for (int j = pattern.length - 1; j >= 0; j--) {//内循环：从最后一个字符开始匹配
                if(j < pattern.length - 1 && pattern[j + 1] == '*') {
                    //1.1：当前相等
                    if(i < str.length && (str[i] == pattern[j] || pattern[j] == '.'))
                        dp[i][j] = dp[i][j + 2] || dp[i + 1][j];
                    else//1.2当前不等
                        dp[i][j] = dp[i][j + 2];
                }else {//若不是"*",看当前是否相等
                    if(i != str.length && (str[i] == pattern[j] || pattern[j] == '.')) {//当前相等
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }
    /**
     * 解法二：递归
     * 15ms
     * @param str
     * @param pattern
     * @return
     */
    public static boolean match2(char[] str, char[] pattern) {
        //str为空,pattern为空
        if(str == null || pattern == null)
            return false;
        return match(str,0,pattern,0);
    }
    /**
     * 先看 * 再看 匹配,当pattern遍历完，return取决于str是否遍历完，str恰好遍历完才返回true，再接下来讨论
     *  1.若当前字符存在下一个字符，看下一个字符是否是 '*'，如果是，有2种情况
     *    一：当前匹配
     *   1.1match(str,i + 1,pattern,j)//跳过str
     *   1.2match(str,i,pattern,j + 2)//跳过pattern
     *  二：当前不匹配
     *     match(str,i,pattern,j + 2)//跳过pattern
     *  2.下一个不是 *
     *    当前匹配 return match(str,i + 1,pattern,j + 1)
     */
    private static boolean match(char[] str,int pStr, char[] pattern,int pPattern){
         if(pPattern == pattern.length){
             //如果遍历完了，就是true，否则false
             return str.length == pStr;
         }
         //注意数组越界,若当前字符存在下一个字符，看下一个字符是否是 '*'
        if(pPattern<pattern.length-1 && pattern[pPattern+1] == '*'){
            if(str.length != pStr && (str[pStr] == pattern[pPattern] ||pattern[pPattern]=='.')){
                //有两种情况
                 return match(str,pStr,pattern,pPattern+2)||match(str,pStr+1,pattern,pPattern);
            }else{
                //当前不匹配
                return match(str,pStr,pattern,pPattern+2);
            }
        }else{
            if(str.length != pStr && (str[pStr] == pattern[pPattern] || pattern[pPattern] == '.')) {
                return match(str, pStr + 1, pattern, pPattern + 1);
            }
        }
       return false;
    }

    /**
     * 递归第二个思路：
     * 先看匹配 ，再看 *
     * 前提：当pattern遍历完，return取决于str是否遍历完，再接下来讨论
     * 1.先看当前字符是否匹配 记录first_isMatch
     * 2.再看下一个字符是否为 '*'
     *   2.1当前匹配first_isMatch && match(str,i + 1,pattern,j)
     *   2.2无论匹配与否match(str,i,pattern,j + 2)//跳过
     * 3.不匹配*，当前字符匹配的前提下，进入到下一个循环
     *   else first_isMatch && match(str,i + 1,pattern,j + 1)
     *
     */
    private boolean match1(char[] str, int i, char[] pattern, int j) {
        if(j == pattern.length)//pattern遍历完了
            return str.length == i;//如果str也完了，返回true，不然false
        //1.先看当前是否匹配
        boolean first_isMatch = (i != str.length) && (str[i] == pattern[j] || pattern[j] == '.');
        //2.再看后面是否有* pattern[j + 1] == '*'
        if(j < pattern.length - 1 && pattern[j + 1] == '*') {
            return match1(str, i, pattern, j + 2) ||
                    (first_isMatch && match1(str, i + 1, pattern, j));
        }else {
            return first_isMatch && match1(str, i + 1, pattern, j + 1);
        }
    }

    public static void main(String args[]){
        String str= "a";
        String pattern = ".*";
        System.out.println(match2(str.toCharArray(), pattern.toCharArray()));
    }
}
