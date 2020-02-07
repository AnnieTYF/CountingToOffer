import java.util.ArrayList;

public class FindNumsSumS {
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
     * 如果有多对数字的和等于S，输出两个数的乘积最小的。
     */
    /**
     * 解法一：两个指针，一个从前往后遍历，一个从后往前遍历
     * 之所以可以这样做一个很重要的条件是这是个递增排序的数列
     * 16ms
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        Integer multiply = null;
        int low = 0;
        int high = array.length-1;
        while(low < high ){
           int temp = array[low] + array[high];
            if(temp == sum){
                Integer cur = array[low] * array[high];
                if(multiply == null || multiply > cur){
                    multiply  = cur;
                    if(result.size() == 0){
                        result.add(array[low]);
                        result.add(array[high]);
                    }else {
                        result.set(0, array[low]);
                        result.set(1, array[high]);
                    }
                }
                low++;
            }else if(temp < sum){
               low++;
            }else{
                high --;
            }
        }
        return result;
    }

    /**
     * 解法二：解法一的改进，假设a<b a*b<(a+1)*(b-1) 所以第一次找见的序列就是要找的序列
     * 所以不必判断乘积，第一次找到的就是最小的
     * 找到的第一组（相差最大的）就是乘积最小的。
     * 证明：考虑x+y=C（C是常数），x*y的大小。不妨设y>=x，y-x=d>=0，
     * 即y=x+d,2x+d=C, x=(C-d)/2, x*y=x(x+d)=(C-d)(C+d)/4=(C^2-d^2)/4，
     * 也就是x*y是一个关于变量d的二次函数，对称轴是y轴，开口向下的抛物线。
     * d是>=0的，d越大, x*y也就越小，d的最大值，是x*y的最小值。
     * 22ms
     */
    public static ArrayList<Integer> FindNumbersWithSum2(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int low = 0;
        int high = array.length-1;
        while(low < high ){
            int temp = array[low] + array[high];
            if(temp == sum){
                result.add(array[low]);
                result.add(array[high]);
                return result;
            }else if(temp < sum){
                low++;
            }else{
                high --;
            }
        }
        return result;
    }

    public static void main(String args[]){
        int [] array = {1,2,4,7,11,15};
        System.out.println(FindNumbersWithSum(array,15));

    }
}
