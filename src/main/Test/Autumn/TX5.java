package Autumn;

import java.util.Scanner;

public class TX5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int q = in.nextInt();
        int[][] index = new int[q][2];
        for(int i = 0; i<q; i++){
            index[i][0] = in.nextInt();
            index[i][1] = in.nextInt();
        }
        solution(s,index);
    }

    public static void solution(String s, int[][] index){
          int len = s.length();
          boolean[][] dp = new boolean[len][len];
          int[][] dp2 = new int[len][len];
          for(int i = 0; i<len;i++){
              dp2[i][i] = 1;
              dp[i][i] = true;
              if(i+1 < len && s.charAt(i) == s.charAt(i+1)){
                  dp[i][i+1] = true;
              }
          }
          for(int i = 2; i<len ; i++){
              for(int j = 0; j<i-1; j++){
                  dp[j][i] = dp[j+1][i-1] && s.charAt(j) == s.charAt(i);
              }
          }
          for(int i = len-1; i>=0 ; i--){
              for(int j = i+1; j<len; j++){
                  if(dp[i][j]){
                      dp2[i][j] = 1;
                  }else{
                      dp2[i][j] = Integer.MAX_VALUE;
                      for(int k = i; k<j ; k++){
                          dp2[i][j] = Math.min(dp2[i][j],dp2[i][k]+dp2[k+1][j]);
                      }
                  }
              }
          }
          for(int[] in : index){
              System.out.println(dp2[in[0]-1][in[1]-1]);
          }
    }
}
