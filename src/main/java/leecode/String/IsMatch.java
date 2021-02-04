package leecode.String;

public class IsMatch {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        //如果以 * 开头，则第一行全是true
        for(int j = 1; j<= p.length() ; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = true;
            }else{
                break;
            }
        }
        for(int i = 1; i<= s.length() ; i++){
            for(int j = 1; j<= p.length() ; j++){
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else if(p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

