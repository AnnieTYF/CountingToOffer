public class TwoDimensionalArrayForSearch {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param args
     */
    public static void main(String args[]){
        int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 1;
        System.out.println(find3(target,array));
    }
    /**
     * 利用该二维数组的性质：
     *
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序
     * 即对于左下角的值 m，m 是该行最小的数，是该列最大的数
     * 每次将 m 和目标值 target 比较：
     *
     * 当 m < target，由于 m 已经是该行最大的元素，想要更大只有从列考虑，取值右移一位
     * 当 m > target，由于 m 已经是该列最小的元素，想要更小只有从行考虑，取值上移一位
     * 当 m = target，找到该值，返回 true
     * 用某行最小或某列最大与 target 比较，每次可剔除一整行或一整列
     * 时间复杂度：O(行高 + 列宽) ->O(N)
     * 空间复杂度：O(1)
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int [][] array) {
        boolean find = false;
        int row = array.length - 1;
        int column = 0;
        while(column < array[0].length  && row>=0 ) {
            if (target == array[row][column]) {
                find = true;
                return find;
            } else if (target > array[row][column]) {
                column = column + 1;
            } else if (target < array[row][column]) {
                row = row - 1;
            }
        }
        return find;
    }

    /**
     * 暴力破解法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param target
     * @param array
     * @return
     */
    public static boolean Find2(int target, int [][] array) {
        boolean find = false;
        int row = array.length - 1;
        int column = array[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 对每一行进行二分查找
     * 遍历数组每一行
     */
    public static boolean find3(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int low = 0, high = array[i].length - 1;
            while (low <= high) {
                int mid = (low + high) >> 1;  //在二进制中按位右移一位相当于十进制的除以2
                if (target > array[i][mid]) {
                    low = mid + 1;
                } else if (target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

}
