package leecode.DynamicProgramming;

import java.util.Arrays;

public class MinInsertions {

    public int minInsertions2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i<n;i++){
            dp[i][i] = 0; //base case，单个字符也为回文
        }
        // 从下向上遍历
        for(int i = n-2; i>=0 ; i--){
            // 从左向右遍历
            for(int j = i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
                }

            }
        }
        return dp[0][n-1];
    }
    public int minInsertions(String s) {
        int n = s.length();
        int[] dp = new int[n];
        // 从下向上遍历
        int temp = 0;
        for(int i = n-2; i>=0 ; i--){
            // 记录 dp[i+1][j-1]
            int pre = 0;
            // 从左向右遍历
            for(int j = i+1; j<n; j++){
                temp = dp[j];
                if(s.charAt(i) == s.charAt(j)){
                    dp[j] = pre;
                }else{
                    dp[j] = Math.min(dp[j],dp[j-1])+1;
                }
                pre = temp;
            }
        }
        return dp[n-1];
    }
}
