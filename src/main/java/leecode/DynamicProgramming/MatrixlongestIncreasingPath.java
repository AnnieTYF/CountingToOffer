package leecode.DynamicProgramming;
/**
 * 329. 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 */
public class MatrixlongestIncreasingPath {
    /**
     * 记忆化深度优先搜索
     *将递归的结果存储下来，这样每个子问题只需要计算一次
     * 时间复杂度优化到 O(mn)
     * 我们多次递归调用 dfs(x, y)。但是，如果我们已经知道四个相邻单元格的结果，就只需要常数时间。
     * 在搜索过程中，如果未计算过单元格的结果，我们会计算并将其缓存；否则，直接从缓存中获取之
     * @param matrix
     * @return
     */
    //深度优先遍历上下左右四个方向
    private static final int[][] dirs = {{0,1},{1,0},{0, -1}, {-1, 0}};
    private int row,col;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        row = matrix.length;
        col = matrix[0].length;
        int[][] cache = new int[row][col];
        int res = 0;
        //矩阵中的任意点都可能为起点，所以要遍历一遍
        for(int i = 0; i<row ; i++){
            for(int j = 0; j<col;j++){
                 res = Math.max(dfs(matrix,i,j,cache),res);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix,int i,int j,int[][] cache){
        //直接从缓存中获取
          if(cache[i][j] != 0){
              return cache[i][j];
          }
          for(int[] d : dirs){
              //上下左右遍历
             int x = i + d[0];
             int y = j+d[1];
             //判断边界条件，以及递增条件
             if(x >= 0 && y>=0 && x<row && y<col && matrix[x][y]>matrix[i][j]){
                 //将该点的最大路径放到缓存中
                   cache[i][j] = Math.max(cache[i][j],dfs(matrix,x,y,cache));
             }
          }
          //每经过一点，路径长度+1
          return ++cache[i][j];
    }
}
