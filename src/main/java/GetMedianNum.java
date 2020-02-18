import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedianNum {
    /**
     * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     */
    /**
     * 这道题是想让你用树的思想来实现的，我们就不用Collections.sort(array)了
     * 正确思路：用两个优先队列做，一个大顶堆，一个小顶堆
     * 保证小顶堆 > 大顶堆，这样最后的中间值就是大顶堆+小顶堆堆顶的平均值
     * 30ms
     */
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    /**
     * 每次插入小顶堆的是当前大顶堆中最大的数
     * 每次插入大顶堆的是当前小顶堆中最小的数
     * 这样保证小顶堆中的数永远大于等于大顶堆中的数
     * 中位数就可以方便地从两者的根结点中获取了
     */
    //记录偶数or奇数
    static int count = 0;
    //插入数据方法
    public static void Insert(Integer num) {
        //个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
       if(count % 2 == 0){
           maxHeap.offer(num);
           int temp = maxHeap.poll();
           minHeap.offer(temp);
       }else{
           //个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
           minHeap.offer(num);
           int temp = minHeap.poll();
           maxHeap.offer(temp);
       }
       count++;
    }
    //求中位数方法
    public static Double GetMedian() {
        //当前为偶数个，则取小顶堆和大顶堆的堆顶元素求平均
        if(count%2 == 0){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }else{
            //当前为奇数个，则直接从小顶堆中取元素即可
            return Double.valueOf(minHeap.peek());
        }
    }
    public static void main(String args[]){
        int[] m = {5,2,3,4,1,6,7,0,8};
        for(int i = 0; i<m.length;i++){
            Insert(m[i]);
        }

    }

}
