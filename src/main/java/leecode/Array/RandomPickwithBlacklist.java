package leecode.Array;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

public class RandomPickwithBlacklist {
    int size;
    Map<Integer,Integer> map;
    Random rand = new Random();
    public RandomPickwithBlacklist (int N, int[] blacklist) {
        map = new HashMap<>();
        // 最终数组中的元素个数
        size = N-blacklist.length;
        //初始化
        Set<Integer> set = new HashSet<>();
        //表示大于等于 N - len(B) 且在白名单中的数
        for (int i = size; i < N; i++) {
            set.add(i);
        }
        // 如果 b 已经在区间 [sz, N),可以直接忽略
        for (int x : blacklist) {
            set.remove(x);
        }
        //把所有小于 N - len(B) 且在黑名单中数一一映射到大于等于 N - len(B) 且出现在白名单中的数
        Iterator<Integer> index = set.iterator();
        for(int key : blacklist){
            if(key < size){
                // 将黑名单中的索引映射到合法数字
                map.put(key,index.next());
            }
        }
    }

    public int pick() {
        // 随机选取一个索引
        int index = rand.nextInt(size);
        // 这个索引命中了黑名单，需要被映射到其他位置
        if(map.containsKey(index)){
           return map.get(index);
        }
        // 若没命中黑名单，则直接返回
        return index;
    }
}
