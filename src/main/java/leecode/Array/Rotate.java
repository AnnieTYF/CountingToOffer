package leecode.Array;

public class Rotate {

    /**
     * 给定 matrix =
     * [
     *   [1,2,3], // x = 0, y = 0
     *   [4,5,6],
     *   [7,8,9]
     * ],
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     * 链接：https://leetcode-cn.com/problems/rotate-image
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //1. 先将矩阵沿着 y=-x 对称轴交换
        for(int i = 0; i<len ; i++){
            for(int j = i ; j< len ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //2. 将每一列倒置
        for(int i = 0; i<len ; i++){
            for(int j = 0 ; j<len/2 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j -1];
                matrix[i][len - j -1] = temp;
            }
        }
    }
}
