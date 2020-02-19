public class MovingRangeOfRobot {
    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
     * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     */

    /**
     * 也是回溯法
     * 19ms
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols)
    {
         boolean[][] flag = new boolean[rows][cols];
         return countSteps(threshold,0,0,rows,cols,flag);
    }

    private int countSteps(int threshold, int i, int j, int rows,int cols, boolean[][] flag){
        //越界，标志位为false，行坐标和列坐标的数位之和大于k
            if(i < 0 || i>=rows || j<0 || j>=cols || flag[i][j] || bitSum(i) + bitSum(j) > threshold){
                 return 0;
            }
            flag[i][j] = true;
            return countSteps(threshold,i-1,j,rows,cols,flag)
                    + countSteps(threshold,i+1,j,rows,cols,flag)
                    + countSteps(threshold,i,j-1,rows,cols,flag)
                    + countSteps(threshold,i,j+1,rows,cols,flag)
                    +1;
    }
    //单个数字的个十位相加
    private  int bitSum(int n){
        int sum = 0;
        while(n != 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}
