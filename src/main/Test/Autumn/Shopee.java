package Autumn;

import java.util.*;

public class Shopee {
    static int h,w;
    static long dp[][];
    static int i,j;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            h = scan.nextInt();
            w = scan.nextInt();
            if(h==0&&w==0)
                break;
            dp = new long[20][3000];

            if(h*w%2==1){
                System.out.println("0");
                continue;
            }
            dp[0][0] = 1;
            for(i=0;i<=h;i++){         //  i为0时 是表示初始化第一行   第一行并没有 1<<w种情况  像101就是不行的
                for(j=0;j<(1<<w);j++){ //  所以 以0  开始 初始化  第1行dp[1][...];
                    if(dp[i][j]!=0){
                        dfs(1,0);
                    }
                }
            }
            System.out.println(dp[h][0]);
        }

    }

    public static void dfs(int x, int s) {
        if(x == w + 1){
            dp[i+1][s] += dp[i][j];
        }else{
            if(((j>>(x-1))&1)==1)
                dfs(x+1,s);
            else{
                if(x+1<=w&&((j>>x)&1)==0) //如果第x+1位 为1的话  就需要给上补0，所以不能横放,而且位数 首先要够
                    dfs(x+2,s);
                dfs(x+1,s|(1<<(x-1)));
            }
        }

    }
}
