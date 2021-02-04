package leecode.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindOrder {
    List<List<Integer>> edges = new ArrayList<>();
    int[] indeg;//记录每个节点的度，就是他跟多少个节点连通
    //找出一种可能的拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indeg = new int[numCourses];
        int[] res = new int[numCourses];
        //创建边缘列表
        for(int i = 0; i<numCourses ; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            edges.get(edge[1]).add(edge[0]);
            ++indeg[edge[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<indeg.length ; i++){
            //找到度==0的节点，作为拓扑排序的开始,因为返回任意一种拓扑排序
            if(indeg[i] == 0){
                queue.offer(i);
            }
        }
        int visited = 0;
        int i=0;
        while(!queue.isEmpty()){
            ++visited;
            Integer temp = queue.poll();
            res[i++] = temp;
            for(Integer next : edges.get(temp)){
                --indeg[next];
                if(indeg[next] == 0){
                    queue.offer(next);
                }
            }
        }
        if(visited != numCourses){
            return new int[0];
        }else{
            return res;
        }
    }
}
