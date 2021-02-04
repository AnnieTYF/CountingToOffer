package leecode.BFS;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.util.*;

public class CanFinish {

    List<List<Integer>> edges = new ArrayList<>();
    int[] indeg; //记录每个节点的度，就是他跟多少个节点连通

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        indeg = new int[numCourses];
        // 对于每个节点都搞一个边缘列表
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        // 添加关系
        for (int[] e : prerequisites) {
            edges.get(e[1]).add(e[0]);
            ++indeg[e[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<numCourses ; i++){
            //找到度==0的节点，作为拓扑排序的开始
            if(indeg[i] == 0){
               queue.offer(i);
            }
        }
        int visited = 0;//记录访问过多少个节点
        while (!queue.isEmpty()) {
            ++visited;
            Integer v = queue.poll();
            for (Integer next : edges.get(v)) {
                --indeg[next];
                //如果排序后，该节点度为0，再度放入队列
                if(indeg[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return visited == numCourses;
    }


}
