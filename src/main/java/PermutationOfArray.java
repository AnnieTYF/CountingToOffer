import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PermutationOfArray {
    /**
     *输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
     */
    /**
     * 解法一：递归实现字符串的全排列
     * 问题转换为先固定第一个字符，求剩余字符的排列；求剩余字符排列时跟原问题一样。
     * (1) 遍历出所有可能出现在第一个位置的字符（即：依次将第一个字符同后面所有字符交换）；
     * (2) 固定第一个字符，求后面字符的排列（即：在第1步的遍历过程中，插入递归进行实现）。
     * 需要注意的几点：
     * (1) 先确定递归结束的条件，例如本题中可设i == str.size() - 1;
     * (2) 输出的排列可能不是按字典顺序排列的，可能导致无法完全通过测试用例，考虑输出前排序，或者递归之后取消复位操作。
     * 211ms
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
          ArrayList<String> result = new ArrayList<>();
          if(str != null&&str.length() > 0){
              PermutationHelper(str.toCharArray(),0,result);
              //结果按字典排序
              Collections.sort(result);
          }
          return result;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> result){
         if(i == chars.length-1){
             //只有一个字符
             String val = String.valueOf(chars);
             /*这个条件是去重，这里的重复不是判断abb中第二个字符和第三个字符相等，就不交换了
             因为这种前后两个数交换的方式会有问题。例如abb，第一个数与后面两个数交换得bab，bba。
             然后abb中第二个数和第三个数相同，就不用交换了。
             但是对bab，第二个数和第三个数不同，则需要交换，得到bba。
             由于这里的bba和开始第一个数与第三个数交换的结果相同了，因此这个方法不行。
             所以我们采用：去重的全排列就是从第一个数字起，每个数分别与它后面非重复出现的数字交换。
             */
             /**
              * 我们这里的处理方式 PS:我觉得很巧
              * 其实我们这里没有在选择交换这里做去重判断
              * 而是再最后添加的时候，用了java方法，是否包含做去重
              */
             if(!result.contains(val)){
                 //这里添加的是整个chars数组，递归将chars排列
                 result.add(val);
             }
         }else{
             for(int j = i;j<chars.length;j++){
                 swap(chars,i,j);
                 PermutationHelper(chars,i+1,result);
                 //复位，因为递归时要保证第一个字符不变，依次和后边的字符交换
                 swap(chars,i,j);
             }
         }
    }

    private void swap(char[] chars,int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * 解法二：非递归，字典排序
     *162ms
     * [例]839647521是1--9的排列。1—9的排列最前面的是123456789，最后面的987654321，
     * 从右向左扫描若都是增的，就到了987654321，也就没有下一个了。否则找出第一次出现下降的位置。
     * 【例】 如何得到346987521的下一个
     * 1，从尾部往前找第一个P(i-1) < P(i)的位置
     *  3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
     *  最终找到6是第一个变小的数字，记录下6的位置i-1
     *
     * 2，从i位置往后找到最后一个大于6的数
     * 3 4 6 -> 9 -> 8 -> 7 5 2 1
     *  最终找到7的位置，记录位置为m
     *
     * 3，交换位置i-1和m的值
     *  3 4 7 9 8 6 5 2 1
     *
     * 4，倒序i位置后的所有数据
     *  3 4 7 1 2 5 6 8 9
     * 则347125689为346987521的下一个排列
     */
    public ArrayList<String> Permutation2(String str){
        ArrayList<String> list = new ArrayList<String>();
        if(str==null || str.length()==0){
            return list;
        }
        char[] chars = str.toCharArray();
        //从最小的开始排序123456
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        int len = chars.length;
        while(true){
            int tail = len-1;
            int front;
           // 从尾部往前找第一个P(i-1) < P(i)的位置，记录位置i-1
            while(tail>=1 && chars[tail-1]>=chars[tail]){
                tail--;
            }
            if(tail == 0)
                break;
            front = tail;
            //从i位置往后找到最后一个大于6的数。记录位置为m
            while(front<len && chars[front]>chars[tail-1]){
                front++;
            }
            //这里用到了上一个方法的swap函数，交换位置i-1和m的值
            swap(chars,tail-1,front-1);
            //倒序i位置后的所有数据
            reverse(chars,tail);
            list.add(String.valueOf(chars));
        }
        return list;
    }
    //倒序i位置后的所有数据
    private void reverse(char[] chars, int k) {
        if (chars == null || chars.length <= k)
            return;
        int len = chars.length;
        //折半交换
        for (int i = 0; i < (len - k) / 2; i++) {
            int m = k + i;
            int n = len - 1 - i;
            if (m <= n) {
                swap(chars, m, n);
            }
        }
    }


}
