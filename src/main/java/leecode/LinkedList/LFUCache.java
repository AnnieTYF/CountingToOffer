package leecode.LinkedList;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    // key 到 val 的映射
    HashMap<Integer,Integer> keyToVal;
    // key 到 freq 的映射
    HashMap<Integer,Integer> keyToFeq;
    // freq 到 key 列表的映射,相同访问次数下的按时间排序的key
    HashMap<Integer, LinkedHashSet<Integer>> feqToKeys;
    // 记录最小的频次
    int minFeq;
    // 记录 LFU 缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFeq = new HashMap<>();
        feqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFeq = 0;
    }

    public int get(int key) {
        if(!keyToVal.containsKey(key)){
            return -1;
        }
        // 增加 key 对应的 freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if(cap <= 0){
            return;
        }
        //如果已存在
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            increaseFreq(key);
        }else{
            /* key 不存在，需要插入 */
            /* 容量已满的话需要淘汰一个 freq 最小的 key */
            if(cap <= keyToVal.size()){
                removeMinFreqKey();
            }
            keyToVal.put(key,value);
            keyToFeq.put(key,1);
            //如果传入key对应的value已经存在，就返回存在的value，不进行替换。如果不存在，就添加key和value，
            feqToKeys.putIfAbsent(1,new LinkedHashSet<>());
            feqToKeys.get(1).add(key);
            // 插入新 key 后最小的 freq 肯定是 1
            minFeq = 1;
        }
    }

    public void increaseFreq(int key){
        int freq = keyToFeq.get(key);
        keyToFeq.put(key,freq+1);
        // 将 key 从 freq 对应的列表中删除
        feqToKeys.get(freq).remove(key);
        // 将 key 加入 freq + 1 对应的列表中
        feqToKeys.putIfAbsent(freq+1,new LinkedHashSet<>());
        feqToKeys.get(freq+1).add(key);
        // 如果 freq 对应的列表空了，移除这个 freq
        if(feqToKeys.get(freq).isEmpty()){
            feqToKeys.remove(freq);
            // 如果这个 freq 恰好是 minFreq，更新 minFreq
            if (freq == minFeq) {
                minFeq++;
            }
        }
    }

    public void removeMinFreqKey(){
        // freq 最小的 key 列表
         LinkedHashSet<Integer> keyList = feqToKeys.get(minFeq);
        // 其中最先被插入的那个 key 就是该被淘汰的 key
        int deleteKey = keyList.iterator().next();
        /* 更新 FK 表 */
        keyList.remove(deleteKey);
        if(keyList.isEmpty()){
            //如果keyList中只有一个元素，那么删除之后minFreq对应的key列表就为空了，也就是minFreq变量需要被更新
            //但是，其实这里没必要更新minFreq变量,因为removeMinFreqKey在put方法中插入新key时可能调用
            //插入新key时一定会把minFreq更新成 1，所以说即便这里minFreq变了，我们也不需要管它
            feqToKeys.remove(minFeq);
        }
        keyToVal.remove(deleteKey);
        keyToFeq.remove(deleteKey);
    }
}
