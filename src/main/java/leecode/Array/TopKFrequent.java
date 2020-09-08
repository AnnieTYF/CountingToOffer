package leecode.Array;

import java.util.*;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer num : nums){
            int count = map.getOrDefault(num,0);
            map.put(num,++count);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(map.entrySet());

        int[] res = new int[k];
        int i;
        for(i = 0; i<k ; i++){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            if(entry != null){
                res[i] = entry.getKey();
            }
        }
        return Arrays.copyOf(res,i);
    }
}
