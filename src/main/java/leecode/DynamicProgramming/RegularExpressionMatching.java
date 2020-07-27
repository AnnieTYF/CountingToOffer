package leecode.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class RegularExpressionMatching {
    /**
     * 常规字符串匹配的递归模式
     */
    boolean isMatch2(String text, String  pattern, int i){
        boolean isCurMatch = false;
        if(pattern.isEmpty()){
            return text.isEmpty();
        }
        if(text.charAt(i) == pattern.charAt(i)){
             isCurMatch = true;
        }
        return isCurMatch && isMatch2(text,pattern,++i);
    }
    /**
     * def isMatch(text, pattern) -> bool:
     *     if not pattern: return not text
     *     first_match = bool(text) and pattern[0] in {text[0], '.'}
     *    if len(pattern) >= 2 and pattern[1] == '*':
     *     return isMatch(text, pattern[2:]) or \
     *             first_match and isMatch(text[1:], pattern)
     *    else:
     *      return first and isMatch(text[1:], pattern[1:])
     * # 解释：如果发现有字符和 '*' 结合，
     *     # 或者匹配该字符 0 次，然后跳过该字符和 '*'
     *     # 或者当 pattern[0] 和 text[0] 匹配后，移动 text
     */
    boolean isMatch(String text, String  pattern){
        if(pattern.isEmpty()){
            return text.isEmpty();
        }
        boolean isCurMatch = false;
        if(!text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.')){
            isCurMatch = true;
        }
        //如果发现有字符和 '*' 结合,或者匹配该字符 0 次，然后跳过该字符和 '*'
        //或者当 pattern[0] 和 text[0] 匹配后，移动 text
        if(pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return isMatch(text,pattern.substring(2)) ||
                    (isCurMatch && isMatch(text.substring(1),pattern));
        }else{
            return isCurMatch && isMatch(text.substring(1),pattern.substring(1));
        }
    }

    /**
     * 动态规划
     * dp[i][j] 表示 s 的前 ii 个是否能被 p 的前 jj 个匹配
     */
    boolean isMatchWithMemo(String text, String  pattern){
       boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
       dp[0][0] = true;
        for (int i = 0; i <= text.length(); ++i) {
            for (int j = 1; j <= pattern.length(); ++j) {
                if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(text, pattern, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
                else {
                   // 如果 pp 的第 j 个字符是一个小写字母，那么我们必须在 s 中匹配一个相同的小写字母，即
                    if (matches(text, pattern, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[text.length()][pattern.length()];
    }
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
