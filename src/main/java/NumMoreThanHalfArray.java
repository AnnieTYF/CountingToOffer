import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumMoreThanHalfArray {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */
    /**
     * 解法一:采用两两抵消的策略，如果存在大于数组一半的数，那一定是最后抵消剩下的数
     * 再遍历一遍，找到该数出现的次数，看看是否大于一半
     * 时间复杂度O(N)
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==0)return 0;
        if(array.length==1)return array[0];
        int flag=1;
        int temp=array[0];

        for(int i=1;i<array.length;i++){
            if(flag==0){
                temp=array[i];
                flag=1;

            }
            else if(temp==array[i]){
                flag++;
            }
            else{
                flag--;
            }

        }
        //这一步存在的必要，因为如果数组中没有超过一半的数，上个循环中的最后flag == 1
        //就不能通过判断flag是否>0来判断是否存在超过半数的数了
        flag=0;
        for(int i=0;i<array.length;i++){
            if(temp==array[i])flag++;
        }
        return (flag>array.length/2)? temp:0;
    }
    /**
     * 解法一的后续：解法一也叫Boyer-Moore 投票算法
     * 如果我们把众数记为 +1+1 ，把其他数记为 -1−1 ，将它们全部加起来，显然和大于 0 ，从结果本身我们可以看出众数比其他数多
     * 这是leecode上面的答案
     * leecode上是默认大于一般的众数总是存在的
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    /**
     * 解法二：快排，时间复杂度O(NlogN)
     * 用快排将数组排序，如果超过半数则数组的中间值一定是该数
     * 怎么说呢，在实际编码中要学会用java自带的API，除非是专门考排序
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    /**
     * 解法三：哈希表，用hashmap记录出现次数
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int majorityElement3(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                map.put(nums[i],++count);
            }else{
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > (nums.length/2)){
                return entry.getKey();
            }
        }
        return 0;
    }

}
