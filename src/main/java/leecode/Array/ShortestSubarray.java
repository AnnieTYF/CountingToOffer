package leecode.Array;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ShortestSubarray {
    /*
   序列：1,4,-2,4
   前缀和：1,5,3,7
   单调栈是 1 3 7 ，7与3的差值一定大于7与5的差值，并且7与3的数组长度要小于7与5的，因此序列5可以被舍弃
    */
    public int shortestSubarray(int[] A, int K) {
        int len = A.length;
        //前缀和，由于该题存在负数，因此前缀和不是递增序列不能直接用
        long[] preSums = new long[len+1];
        for(int i = 0; i< len ; i++){
            preSums[i+1] = preSums[i] + A[i];
        }
        int min = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        //构建前缀和的单调队列，非单调栈序列可以转化为单调栈，同时问题转化为在前缀和第i个元素时
        //从0开始查找找到单调栈中第一个前缀和，使得两者差值大于K。
        for(int i = 0; i < preSums.length ; i++){
            //当我们遇到了一个新的下标 y 时，我们会在队尾移除若干元素，直到 P[y] 单调递增
            while(!deque.isEmpty() && preSums[i] <= preSums[deque.getLast()]){
                deque.removeLast();
            }
            //同时，我们会在队首也移除若干元素，如果 P[y] >= P[x0] + K，则将队首元素移除，直到该不等式不满足
            while(!deque.isEmpty() && preSums[i] >= K + preSums[deque.getFirst()]){
                min = Math.min(min,i - deque.removeFirst());
            }
            deque.addLast(i);
        }
        return min == Integer.MAX_VALUE ? -1:min;
    }

}
