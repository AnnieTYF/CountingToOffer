package leecode.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxSlidingWindow {

    static class MonotonicQueue{
        LinkedList<Integer> q = new LinkedList<>();
        public void push(int n) {
            // 将小于 n 的元素全部删除
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            // 然后将 n 加入尾部
            q.addLast(n);
        }
        public int max() {
            // 队头的元素肯定是最大的
            return q.getFirst();
        }
        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i<nums.length ; i++){
            if(i < k-1){
                //先填满窗口的前 k - 1
                window.push(nums[i]);
            }else{
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.add(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums, 3);
    }
}
