package Autumn;

import java.util.Random;
import java.util.Scanner;

public class Di2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //测试数据
        int T = in.nextInt();
        while(T-- != 0){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int[][] nums = new int[m][3];
            while(m-- != 0){
                nums[m][0] = in.nextInt();
                nums[m][1] = in.nextInt();
                nums[m][2] = in.nextInt();
            }
            solution(nums,n,k);
        }
    }

    public static void solution(int[][] nums, int n, int k){
        boolean[][] grid = new boolean[n][n];
        for(int[] num : nums){
            if(num[2] <= k){
                grid[num[0]-1][num[1]-1] = true;
                grid[num[1]-1][num[0]-1] = true;
            }
        }
        boolean[] vis = new boolean[n];
        DFS(grid,vis,0);
        for(boolean v : vis){
            if(!v){
                System.out.print("No");
                return;
            }
        }
        System.out.print("Yes");
    }

    public static void DFS(boolean[][] grid, boolean[] vis, int index){
        vis[index] = true;
        for(int i = 0; i<vis.length;i++){
            if(grid[index][i] && !vis[i]){
                DFS(grid,vis,i);
            }
        }
    }
}
