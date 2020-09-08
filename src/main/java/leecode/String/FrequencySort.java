package leecode.String;

import java.util.*;

public class FrequencySort {
    /**
     *给定一个字符串，请将字符串里的字符按照出现的频率降序排列
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char chr : s.toCharArray()) {
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }
        /*
        或者map用数组代替
         int[] letters = new int[128];
        for (char c : s.toCharArray()) {
            letters[c]++;
        }
        PriorityQueue<Character> heap = new PriorityQueue<>(128, (a, b) -> Integer.compare(letters[b], letters[a]));
         */
        //map的EntrySet构建大顶堆
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(map.entrySet());

        StringBuilder res = new StringBuilder(s.length());

        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for(int i = 0; i<entry.getValue() ; i++){
                res.append(entry.getKey());
            }
        }
        return res.toString();
    }
}
