/*
import java.util.LinkedHashMap;
import java.util.Map;

 class LRUvalue{
    private Integer value;
    private long endTime;
}
public class LRU {
    //实现一个LRU cache
    //如果cache的put操作可传入一个过期时间，该如何做
    Map<Integer,LRUvalue> map;
    int capcity = 10;
    public LRU(int capcity,long time){
        this.capcity = capcity;
        map = new LinkedHashMap<>();
    }
    private void get(){
        System.currentTimeMillis() -
    }
    public void put(int key , int value){
        //包含
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
        }
        //不包含
        map.put(key,value);
        //超出容量

        if(map.size() > capcity ){
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}
*/
