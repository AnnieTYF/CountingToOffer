package leecode.Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        while(left <= right && top <= bottom){
            for(int i = left ; i<=right ; i++){
                 res.add(matrix[top][i]);
            }
            for(int j = top+1 ; j<= bottom ; j++){
                 res.add(matrix[j][right]);
            }
            if(left < right && top < bottom){
                for(int i = right-1; i> left ; i--){
                    res.add(matrix[bottom][i]);
                }
                for(int j = bottom ; j>top ; j--){
                    res.add(matrix[j][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int target = matrix[0].length * matrix.length;
        while(target >= 1){
            //&& target >= 1 是为了防止偶数情况矩阵中心重复填充
            for(int i = left ; i<=right && target >= 1; i++){
                res.add(matrix[top][i]);
                target--;
            }
            top++;
            for(int j = top ; j<= bottom && target >= 1; j++){
                res.add(matrix[j][right]);
                target--;
            }
            right--;
            for (int i = right; i >= left && target >= 1; i--) {
                res.add(matrix[bottom][i]);
                target--;
            }
            bottom--;
            for (int j = bottom; j >= top && target >= 1; j--) {
                res.add(matrix[j][left]);
                target--;
            }
            left++;
        }
        return res;
    }
}
