package leecode.Array;

import java.util.ArrayList;
import java.util.List;

public class FindDiagonalOrder {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
        int n = matrix[0].length;
        int m = matrix.length;
        int runTimes = m + n -1; //一共有几个对角线
        List<Integer>[] res = new ArrayList[runTimes];
        for(int i = 0; i< m ; i++){
            for(int j = 0; j<n ; j++){
                int sum = i + j; //一样x+y的坐标的值是在同一条线上的
                if (res[sum] == null){
                    res[sum] = new ArrayList<>();
                }
                // 当x+y的和是偶数的时候，线是向上斜走的,x坐标大的数是排在前面
                if(sum % 2 == 0){
                    res[sum].add(0,matrix[i][j]);
                }else{
                    res[sum].add(matrix[i][j]);
                }
            }
        }
        int[] ans = new int[m * n];
        int index = 0;
        for (int k = 0; k < res.length; k++) {
            if (res[k] != null) {
                for (int num : res[k]) {
                    ans[index++] = num;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
       int[][] matrix = {{ 1, 2, 3},{4, 5, 6 },{ 7, 8, 9}};
        findDiagonalOrder(matrix);
    }
}
