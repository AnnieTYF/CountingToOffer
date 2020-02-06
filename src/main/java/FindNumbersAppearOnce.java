import java.util.HashMap;
import java.util.Map;

public class FindNumbersAppearOnce {
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     */

    /**
     * 自己解的
     * 21ms
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                count = map.get(array[i]);
                map.put(array[i], ++count);
            } else {
                map.put(array[i], 1);
            }
        }
        int flag = 0;
        for (int j = 0; j < array.length; j++) {
            if (map.get(array[j]) == 1 ) {
                if (flag == 0) {
                    num1[0] = array[j];
                    flag++;
                } else {
                    num2[0] = array[j];
                }
            }
        }
    }

    /**
     * 正经解法：利用位运算中异或的性质：两个相同数字异或等于0，一个数和0异或还是它本身。
     * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，
     * 最后剩下的就是落单的数，因为成对儿出现的都抵消了。
     * 回到原问题
     * 如果能够把原数组分为两个子数组。
     * 在每个子数组中，包含一个只出现一次的数字，而其它数字都出现两次。
     * 就能按照前面的办法就是分别求出这两个只出现一次的数字了
     * 拆分方法：
     * 我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
     * 我们就取第一个1所在的位数，假设是第N位，
     * 接着把原数组分成两组，分组标准是第N位是否为1。
     * 如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
     * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
     * 21ms
     */

    public static void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        if(array==null ||array.length<2)
            return ;
        int temp = 0;
        //先总体异或，找到两个出现一次的数异或的结果，两个数不同位，即分组标准
        for(int i=0;i<array.length;i++)
            temp ^= array[i];

        int indexOf1 = findFirstBitIs(temp);
        for(int i=0;i<array.length;i++){
            if(isBit(array[i], indexOf1))
                num1[0]^=array[i];
            else
                num2[0]^=array[i];
        }
    }
    //两个不同的数异或后，找到第一个1的位置，因为1代表两个数那个位不同
    public static int findFirstBitIs(int num){
        int indexBit = 0;
        //比如011，第0为为1 ； 100，第2为为1
        //注意这里的判断条件，int类型32位，不能超过这个位数
        while(((num & 1)==0) && (indexBit)<8*4){
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }
    //分组，如果在第N位为1，就分到num1组异或，如果不为1，就分到num2组异或
    public static boolean isBit(int num,int indexBit){
        num = num >> indexBit;
        return (num & 1) == 1;
    }


    public static void main(String args[]){
        int [] array = {1,1,2,3,3,4,4,6};
        int[] num1 = {0};
        int[] num2 = {0};
        FindNumsAppearOnce2( array , num1,num2);
    }

}
