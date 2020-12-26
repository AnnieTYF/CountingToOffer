package leecode.DynamicProgramming;

public class FindMaxForm {

    //多重背包问题，二维背包问题
    public int findMaxForm(String[] strs, int m, int n) {
        int w0 ;
        int w1 ;
        //dp[i][j] 当有 i 个0和 j 个1的时候有几个子集
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i<= strs.length ; i++){
            w0 = 0;
            w1 = 0;
            for(char ch : strs[i-1].toCharArray()){
                if(ch == '0'){
                    w0++;
                }else{
                    w1++;
                }
            }
            // 01背包, 逆向迭代更新dp
            for(int j = m; j >= w0 ; j--){
                for(int k = n ; k>=w1 ; k--){
                    //减去两种重量时的子集数加当前子集（子集数+1）
                     dp[j][k] = Math.max(dp[j][k],1+dp[j-w0][k-w1]);
                }
            }
        }
        return dp[m][n];
    }
}
