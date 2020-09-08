package Autumn;

import java.util.*;

public class Meituan4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] relation = new int[m][2];
        for(int i = 0; i<m ; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            relation[i][0] = b;
            relation[i][1] = a;
        }
        solution(n,m,relation);
    }

    public static void solution(int n, int m, int[][] relation){
        int res = 0;
        List<List<String>> lists = new ArrayList<>();
        int[][] grid = new int[n+1][n+1];
        for(int i = 1; i<=n ; i++){
            grid[i][i] = 1;
        }
        for(int i = 0; i<m ; i++){
            int o1 = relation[i][0];
            int o2 = relation[i][1];
            grid[o1][o2] = 1;
            grid[o2][o1] = 1;
        }
        int[] vis = new int[n+1];
        for(int i = 1; i<=n ; i++){
            List<String> list = new ArrayList<>();
            Set<Integer> set = new TreeSet<>();
            dfs(i,grid,vis,set);
            for(Integer integer : set){
               list.add(integer+" ");
            }
            if(set.size() !=0){
                res++;
                lists.add(list);
            }
        }
        System.out.println(res);
        for(List<String> list : lists){
            for(String str : list){
                System.out.print(str);
            }
            System.out.println();
        }
    }

    public static void dfs(int start, int[][] grid, int[] vis, Set<Integer> set){
        if(vis[start] == 1){
            return;
        }
        vis[start] =1;
        set.add(start);
        for(int i = 1; i<vis.length;i++){
            if(grid[start][i] == 1){
                dfs(i,grid,vis,set);
            }
        }
    }
}
