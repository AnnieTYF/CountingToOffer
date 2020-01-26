import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 还有可能是n*m矩阵！！
 */
public class PrintOutMatrix {
    public static void main(String args[]){
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        ArrayList arrayList = printMatrix ( matrix);
        System.out.println("count: "+ arrayList);
    }

    /**
     * 解法一：确定首尾界限，这个也可以把递归改成循环
     * @param matrix
     * @return
     */
   public static   ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList array = new ArrayList();
        if(matrix[0].length == 0){
            return null;
        }
        if(matrix.length == 0){
            return null;
        }
        int lenLeft = 0;
        int heightLow = 0;
        int lenRight = matrix[0].length-1;
        int heightHigh = (matrix.length)-1;

        return circle(lenLeft,lenRight,heightLow,heightHigh,array,matrix);
    }

    private static ArrayList<Integer> circle(int lenLeft, int lenRight, int heightLow, int heightHigh, ArrayList array,int [][] matrix){
        if(lenLeft <= lenRight && heightLow <= heightHigh  ){
            //如果只剩一行
            if(heightLow == heightHigh) {
                for(int k = lenLeft; k <= lenRight; k++){
                    array.add(matrix[heightLow][k]);
                }
                return array;
            }
            //如果只剩一列
            if(lenLeft == lenRight) {
                for(int p = heightLow; p <= heightHigh; p++){
                    array.add(matrix[p][lenLeft]);
                }
                return array;
            }

            for(int i = lenLeft; i<=lenRight;i++){
                array.add(matrix[heightLow][i]);
            }
            heightLow++;
            for(int j = heightLow ; j<=heightHigh;j++){
                array.add(matrix[j][lenRight]);
            }
            lenRight--;
            for(int m = lenRight; m>= lenLeft;m--){
                array.add(matrix[heightHigh][m]);
            }
            heightHigh--;
            for(int n = heightHigh ; n >= heightLow ; n--){
                array.add(matrix[n][lenLeft]);
            }
            lenLeft++;
            circle(lenLeft,lenRight,heightLow,heightHigh,array,matrix);
        }
        return array;
    }


    /*
     * 解法二：
     * 采用旋转魔方的方式 一次取一行，然后旋转
     */
    public static  ArrayList<Integer> printMatrix_2(int[][] matrix) {
        ArrayList<Integer> al = new ArrayList<>();
        int row = matrix.length;
        while (row != 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                al.add(matrix[0][i]);
            }
            if (row == 1)
                break;
            matrix = turn(matrix);
            row = matrix.length;
        }
        return al;
    }

    private static int[][] turn(int[][] matrix) {
        // TODO 自动生成的方法存根
        int col = matrix[0].length;
        int row = matrix.length;
        int[][] newMatrix = new int[col][row - 1];
        for (int j = col - 1; j >= 0; j--) {
            for (int i = 1; i < row; i++) {
                newMatrix[col - 1 - j][i - 1] = matrix[i][j];
            }
        }
        return newMatrix;
    }


    /**
     * 解法一：顺时针旋转
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix_1(int[][] matrix) {
        ArrayList<Integer> al = new ArrayList<>();
        int row = matrix.length;
        if (row == 0)
            return al;
        int col = matrix[0].length;
        // 短的边/2，向上取整，转几圈，这里真的很巧，第几圈后面打印的时候就减几
        int circle = ((row > col ? col : row) + 1) / 2;
        for (int i = 0; i < circle; i++) {

            // 从左向右打印，j=i; j<col-i,
            // 这一行的前i个已经在第i圈从下往上被打印，故j=i
            // 倒数i个都已经在第i圈从上往下被打印，故j=col-i-1<col-i
            for (int j = i; j < col - i; j++)
                al.add(matrix[i][j]);

            // 从上往下打印，j=i+1;j<row-i,
            // 这一列的前i+1个已经在从左向右打印时被打印,故j=i+1
            // 倒数i个已经在第i圈从右往左被打印,故j=row-i-1<row-i
            for (int j = i + 1; j < row - i; j++)
                al.add(matrix[j][col - i - 1]);

            // 从右往左打印，j=col-i-2;j>=i&&row-i-1!=i;，
            // 这一行倒数i个已经在第i圈从上往下被打印
            // 这一行倒数第i+1个已经在从上往下时被打印，故j=col-1-(i+1)=col-i-2
            // 这一行的前i个已经在从下往上时被打印，故j=i>=i
            // 当第i圈为0时即从未由上往下打印时，col有多列时，会造成重复打印，故判断row-i-1!=i以避免
            for (int j = col - i - 2; j >= i && row - i - 1 != i; j--)
                al.add(matrix[row - i - 1][j]);

            // 从下往上打印，j=row-i-2;j>i&&col-i-1!=i，
            // 这一列倒数i个已经在第i圈从右往作被打印
            // 这一列倒数第i+1个已经在从右往左时被打印，故j=row-1-(i+1)=row-i-2
            // 这一列的前i个已经在第i圈从左往右时被打印，
            // 这一列的第i+1个已经在本圈从左往右被打印，故j=i+1>i
            // 当第i圈为0时即从未由右向左打印时，row有多行时，会造成重复打印，故判断col-i-1!=i以避免
            for (int j = row - i - 2; j > i && col - i - 1 != i; j--)
                al.add(matrix[j][i]);
        }
        return al;
    }
}
