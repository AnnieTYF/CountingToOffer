import java.util.*;

public class GetLeastNumber {
    /**
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     *
     * 这道题应该考排序算法，堆排序，快排，冒泡排序（这里的冒泡排序遍历前k个数就可以了）
     */

    /**
     * 解法一：这个。。就很简单了，也没有什么算法在里面
     * O(nlogn)
     * 22ms
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> array = new ArrayList<>();
        if(input == null || input.length == 0 || k>input.length){
            return array;
        }
        Arrays.sort(input);
       for(int i = 0; i<k ; i++){
           array.add(input[i]);
       }
       return array;
    }

    /**
     * 解法二：使用小顶堆
     * 使用优先队列，基于堆的优先队列，并没有将元素进行排序，
     * 而只是在利用最大堆或最小堆的性质在堆顶保存了最大值或者最小值。
     *
     * (1) 遍历输入数组，将前k个数插入到推中；
     * (2) 继续从输入数组中读入元素做为待插入整数，并将它与堆中最大值比较：
     * 如果待插入的值比当前已有的最大值小，则用这个数替换当前已有的最大值；
     * 如果待插入的值比当前已有的最大值还大，则抛弃这个数，继续读下一个数。
     * 这样动态维护堆中这k个数，以保证它只储存输入数组中的前k个最小的数，最后输出堆即可
     * O(nlogk)
     * 22ms
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return res;
        }
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < input.length; i++) {
            if (queue.size() < k) {
                queue.add(input[i]);
            } else {
                if (input[i] < queue.peek()) {
                    queue.remove();
                    queue.add(input[i]);
                }
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }

    /**
     * 解法三：快速排序
     * 20ms,快排的代码量真的太大了
     * O(NlogN)
     */
    public ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return res;
        }
        quickSort(input,0,input.length-1);
        for(int i = 0; i< k ;i++){
            res.add(input[i]);
        }
        return res;
    }
    private  int partition( int[] arr ,int left, int right){
        int temp = arr[left];
        while (right > left){
            // 先判断基准数和后面的数依次比较
            while (temp <= arr[right] && left < right){
                --right;
            }
            if(temp > arr[right] && left < right){
                arr[left] = arr[right];
                ++left;
            }
            // 再判断基准数和前的数依次比较
            while (temp >= arr[left] && left < right){
                ++left;
            }
            if(temp < arr[left] && left<right){
                arr[right] = arr[left];
                --right;
            }
        }
        //中间的数为基数
        arr[left] = temp;
        return left;
    }
    private  void quickSort(int[] arr ,int left, int right){
        if (arr == null || left >= right || arr.length <= 1)
            return;
        int mid = partition(arr,left, right);
        quickSort(arr,left,mid); // 递归调用
        quickSort(arr,mid+1,right);
    }

    /**
     * 解法四：冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。 [1]
     * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 我们这里可以改一下，使最后的元素是最小的数
     * O(KN)
     * 18ms
     */
    public ArrayList<Integer> GetLeastNumbers_Solution4(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return res;
        }
        for(int i = 0; i< k ;i++){
            for(int j = 0; j<input.length-i-1;j++){
                if(input[j] < input[j+1]){
                   int temp = input[j];
                   input[j] = input[j+1];
                   input[j+1] = temp;
                }
            }
            res.add(input[input.length-i-1]);
        }
        return res;
    }
}
