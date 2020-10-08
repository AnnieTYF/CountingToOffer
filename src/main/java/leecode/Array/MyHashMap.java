package leecode.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 706. 设计哈希映射
 */
class Pair<K,V>{
    public K key;
    public V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
class Bucket{
    private List<Pair<Integer,Integer>> bucket;

    public Bucket(){
        this.bucket = new LinkedList<Pair<Integer,Integer>>();
    }

    public Integer get(Integer key){
        for(Pair<Integer,Integer> pair : this.bucket){
            if(pair.key.equals(key)){
                return pair.value;
            }
        }
        return -1;
    }

    public void update(Integer key, Integer value){
        boolean found = false;
        for(Pair<Integer,Integer> pair : this.bucket){
            if(pair.key.equals(key)){
                pair.value = value;
                found = true;
            }
        }
        if(!found){
            this.bucket.add(new Pair<>(key,value));
        }
    }

    public void remove(Integer key){
        for(Pair<Integer,Integer> pair : this.bucket){
            if(pair.key.equals(key)){
               this.bucket.remove(pair);
               // 用到了iterator,remove当前元素以后和里面的.next冲突了。
                // 解决的办法要么加break，要么用正常的循环
               break;
            }
        }
    }
}
public class MyHashMap {

    private int keyCapacity;
    private List<Bucket> hashTable;
    /** Initialize your data structure here. */
    public MyHashMap() {
         this.keyCapacity = 2069;
         this.hashTable = new ArrayList<Bucket>();
         for(int i = 0; i<this.keyCapacity ; i++){
             this.hashTable.add(new Bucket());
         }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashCode = key % this.keyCapacity;
        this.hashTable.get(hashCode).update(key,value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashCode = key % this.keyCapacity;
        return this.hashTable.get(hashCode).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashCode = key % this.keyCapacity;
        this.hashTable.get(hashCode).remove(key);
    }
}
