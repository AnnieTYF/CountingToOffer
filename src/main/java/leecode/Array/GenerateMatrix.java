package leecode.Array;

public class GenerateMatrix {
    public int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int num = 0;
        while(left <= right && top <= bottom){
            for(int i = left; i<=right ; i++){
                res[top][i] = ++num;
            }
            for(int j = top+1; j<=bottom ; j++){
                res[j][right] = ++num;
            }
            if(left < right && top < bottom){
                for(int i = right-1 ; i> left ; i--){
                    res[bottom][i] = ++num;
                }
                for(int j = bottom ; j> top ; j--){
                    res[j][left] = ++num;
                }
            }
            left++;
            right--;
            bottom--;
            top++;
        }
        return res;
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int target = 1;
        while(target <= n*n){
            for(int i = left; i<=right ; i++){
                res[top][i] = target;
                target++;
            }
            top++;
            for(int j = top; j<=bottom ; j++){
                res[j][right] = target;
                target++;
            }
            right--;
            for(int i = right ; i>= left ; i--){
                    res[bottom][i] = target;
                    target++;
            }
            bottom--;
            for(int j = bottom ; j>= top ; j--){
                res[j][left] = target;
                target++;
            }
            left++;
        }
        return res;
    }
}
