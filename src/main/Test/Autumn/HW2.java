package Autumn;

public class HW2 {

    /** 动态规划：
     *  状态转移方程：
     *  if(array[i]) == array[j]{
     *      res[i][j] = res[i-1][j-1]+1 //元素相同
     *  }else{
     *      res[i][j] = 0;//元素不同
     *  }
     *  max = Math.max(max, res[i][j]);
     */
    public static int getLongest(int[] array1 , int[] array2){

        int[][] res = new int[array1.length+1][array2.length+1];
        int max = 0;
        for(int i = 0; i<array1.length ; i++){
            for(int j = 0; j<array2.length ; j++){
                if(array1[i] == array2[j]){
                    res[i+1][j+1] = res[i][j] +1;
                    max = Math.max(max,res[i+1][j+1]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,3};
        int[] array2 = {0,2,3};
        System.out.println(getLongest(array1 , array2));
    }
}
