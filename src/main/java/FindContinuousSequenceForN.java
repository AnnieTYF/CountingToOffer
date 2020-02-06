import java.util.ArrayList;

public class FindContinuousSequenceForN {
    /**
     * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     * 例如 18,19,20,21,22相加为100  ，9-16 相加为100
     */

    /**
     * 解法一：有一个非常好的算法，双指针法，滑动窗口。
     * 有两个指针，分别代表窗口两侧，根据需要的窗口大小调节指针的界限——窗口的位置和宽度
     * 18ms(改进cur的公式后)
     * 28ms
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int low = 1;
        int high = 2;
        while(low < high){

            //注意这个的定义位置，每次循环创建一个新的list
            ArrayList<Integer> list = new ArrayList<>();
            //这里可以改进一下,等差数列求和1+2+3+...+n = n/2(a1+an)
            int cur = (low + high)*(high-low+1)/2;
           /*
           int cur = 0;
           for(int i = low ; i<=high;i++){
                cur = cur + i;
            }*/

            if(cur == sum){
                for(int i = low ; i<=high;i++){
                   list.add(i);
                }
              array.add(list);
                //注意这里，相等后，要移动窗口
                low++;
            }else if(cur < sum){
                high++;
            }else{
                low++;
            }
        }
        return array;
    }
    public static void main(String args[]){
        System.out.println(FindContinuousSequence(100));
    }
}
