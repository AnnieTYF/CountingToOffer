import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxSlideWindow {
    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
     * 每个窗口的最大值分别为{4,4,6,6,6,5}
     */

    /**
     * 解法一：大顶堆
     * O(nlogn)
     * 22ms
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> array = new ArrayList<>();
        if(size == 0){
            return array;
        }
        int low = 0;
        int high = size;
        while(high<=num.length){
            PriorityQueue<Integer> max = new PriorityQueue<>(3, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            for(int i = low; i<high;i++){
                max.offer(num[i]);
            }
            array.add(max.poll());
            low ++;
            high ++;
        }
        return array;
    }

    /**
     * 解法二：双向队列，O(N)
     * 滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
     *  原则：
     *  用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
     * 1. 新增加的值从队尾开始比较，把所有比他小的值丢掉
     * 2. 判断当前最大值是否过期
     *
     * 24ms
     */
    public static ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(size == 0){
            return result;
        }
        //双端队列，用来记录每个窗口的最大值下标,先进先出
        LinkedList<Integer> list = new LinkedList<>();
       for(int i = 0; i<num.length;i++ ){
           //新增加的值从队尾开始比较，把所有比他小的值丢掉，为了保证队首是最大值
           while(!list.isEmpty() && num[list.peekLast()]<num[i]){
               list.pollLast();
           }
           //添加的是下标
           list.addLast(i);
           //判断队首元素是否过期
           if(list.peekFirst() == i-size){
               list.pollFirst();
           }
           //向result列表中加入元素，从第一个size元素开始添加，没轮一次添加一个数
           if(i >= size - 1){
               result.add(num[list.peekFirst()]);
           }
       }
        return result;
    }

    public static void main(String args[]){
        int[] m = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> list = maxInWindows2(m,3);
        for(Integer num : list){
            System.out.println(num);
        }
    }
}
