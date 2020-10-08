package leecode.Array;

import java.util.*;

public class RandomizedSet {
    Map<Integer,Integer> valueOfIndex; //记录每个元素对应在 nums 中的索引
    List<Integer> array;// 存储元素的值
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueOfIndex = new HashMap<>();
        array = new ArrayList<>();
    }
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valueOfIndex.containsKey(val)){
            return false;
        }
        array.add(val);
        valueOfIndex.put(val,array.size()-1);
        return true;
    }
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valueOfIndex.containsKey(val)){
            return false;
        }
        // 先拿到 val 的索引
        int index = valueOfIndex.get(val);
        int lastElement = array.get(array.size()-1);
        // 交换 val 和最后一个元素
        array.set(index,lastElement);
        // 将最后一个元素对应的索引修改为 index
        valueOfIndex.put(lastElement,index);
        // 在数组中删除元素 val
        array.remove(array.size()-1);
        // 删除元素 val 对应的索引
        valueOfIndex.remove(val);
        return true;
    }
    /** Get a random element from the set. */
    public int getRandom() {
        return array.get(rand.nextInt(array.size()));
    }
}
