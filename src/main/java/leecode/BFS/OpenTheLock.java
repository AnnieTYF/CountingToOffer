package leecode.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for(String dead : deadends){
            deads.add(dead);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int step = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for(int i = 0; i<size;i++){
                String cur = queue.poll();
                //判断是否是结束条件
                if(deads.contains(cur)){
                    continue;
                }
                if(cur.equals(target)){
                    return step;
                }

                //将cur周围的节点加入到队列
                for(int j= 0 ;j< 4 ;j++ ){
                    String up = plusOne(cur,j);
                    String down = minusOne(cur,j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        //找不到返回-1
        return -1;
    }
    public String plusOne(String cur, int j){
        char[] ch = cur.toCharArray();
        if(ch[j] == '9'){
            ch[j] = '0';
        }else{
            ch[j] += 1;
        }
        return new String(ch);
    }
    public String minusOne(String cur, int j){
        char[] ch = cur.toCharArray();
        if(ch[j] == '0'){
            ch[j] = '9';
        }else{
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
