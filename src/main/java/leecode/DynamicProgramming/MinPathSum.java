package leecode.DynamicProgramming;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int  row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        //base case
        dp[0][0] = grid[0][0];
        for(int j = 1; j<column ; j++){
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        for(int i = 1; i<row ; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        for(int i = 1; i<row ; i++){
            for(int j = 1 ; j<column ; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row-1][column-1];
    }
}
