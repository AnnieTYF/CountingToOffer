public class ReOrderArray {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public static void main(String args[]){
        int []array = {1,2,3,8,9};
        reOrderArray(array);
    }

    /**
     * 解法一：这是最容易想到的
     * @param array
     */
    public static void reOrderArray(int [] array) {
        //排序算法的稳定性，直接插入排序
        int[] arrayOdd = new int[array.length ];
        int[] arrayEven = new int[array.length];
        int i = 0;
        int j = 0;
        int p = 0;
        while(i < array.length && j<array.length && p<array.length){
            if(array[i]%2 == 0){
                arrayEven[j] = array[i];
                j++;
            }else{
                arrayOdd[p] = array[i];
                p++;
            }
            i++;
        }
        System.arraycopy(arrayOdd, 0, array, 0, p);
        System.arraycopy(arrayEven, 0, array, p, j);
    }

    /**
     * 解法二：
     * @param array
     */
    public static void reOrderArray2(int [] array) {
        //排序算法的稳定性，直接插入排序，选择排序
         int k =0;//记录已经摆好位置的奇数的个数,这个是关键
         for(int i = 0; i< array.length ; i++){
             if(array[i]%2 != 0){
                 int j = i;
                 while(j > k){
                     int temp = array[j];
                     array[j] = array[j-1];
                     array[j-1] = temp;
                     j--;
                 }
                 k++;
             }
         }
    }

}
