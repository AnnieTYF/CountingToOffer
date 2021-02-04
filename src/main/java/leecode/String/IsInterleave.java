package leecode.String;

public class IsInterleave {
    //回溯
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return backtrace(0,0,0,s1,s2,s3);
    }
    public boolean backtrace(int p1,int p2, int index, String s1, String s2, String s3){
        if(index == s3.length()){
            return true;
        }
         //当前字母不同
         if(p1 < s1.length() && s1.charAt(p1) == s3.charAt(index)){
              if(backtrace(++p1,p2,++index,s1,s2,s3)){
                  return true;
              }
              p1--;
              index--;
         }
        if(p2 < s2.length() && s2.charAt(p2) == s3.charAt(index)){
             if(backtrace(p1,++p2,++index,s1,s2,s3)){
                 return true;
             }
             p2--;
             index--;
         }
        return false;
    }

    /**
     * 动态规划
     *
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i=1; i<=s1.length(); i++) {
            if (dp[i - 1][0] && s3.charAt(i-1) == s1.charAt(i-1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i=1; i<=s2.length(); i++) {
            if (dp[0][i-1] && s3.charAt(i-1) == s2.charAt(i-1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for(int i = 1; i < s1.length() ; i++){
            for(int j = 1; j < s2.length() ; j++){
                if(dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }else if(dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
