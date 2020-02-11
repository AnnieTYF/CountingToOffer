import java.util.HashMap;
import java.util.HashSet;

public class FindRepeatableNumInArray {
    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内,数组中某些数字是重复的
     * 请找出数组中第一个重复的数字
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
     * numbers:     an array of integers
     * length:      the length of array numbers
     *  duplication: (Output)，长度为1
     */


    /**
     * 解法一：
     * 30ms
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<length ; i++){
            if(!map.containsKey(numbers[i])){
                map.put(numbers[i],1);
            }else{
                int count = map.get(numbers[i]);
                map.put(numbers[i],++count);
            }
        }
        for(int j = 0; j<length ; j++){
           if(map.get(numbers[j]) > 1){
               duplication[0] = numbers[j];
         //      System.out.println(duplication[0]);
               return true;
           }
        }
        return false;
    }

    /**
     * 解法二：Hashset，无序，唯一
     * 21ms
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate2(int numbers[],int length,int [] duplication) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<length;i++) {
            if(!hs.add(numbers[i])) {
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 解法三：省空间
     * (1)boolean不是占1位，计算机处理处理数据的最小单元是1字节，一般1位的话，其余7位会被0补齐。
     * (2)在java虚拟机规范中，JVM没有用于操作boolean的字节码指令，在编译后用int的数据类型代替boolean，此时boolean
     * 占4字节。
     * (3)boolean[]数组编译后会被byte[]数组代替，此时的boolean占1字节。
     * 总结:boolean单独存在占4字节，在boolean[]中占1字节。
     * 23ms
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate3(int numbers[], int length, int[] duplication) {
        //k的下表代表数组中的值，k的值用来判断是否重复，boolean默认false
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }

    public static void main(String args[]){
        int[] numbers = {2,3,1,0,2,5,3};
        int[] duplication = new int[1];
        System.out.println(duplicate3(numbers,numbers.length,duplication));
    }

}
