package Autumn;

import java.util.Scanner;

public class TX4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] array = new long[n];
        for(int i = 0; i<n ; i++){
            array[i] = in.nextLong();
        }
        solution(array);
    }

    /**
     * 比如33234，我们就先横着刷两次（因为最小值是2)，然后就变成了11012，分
     * 割成了11和12两个小区间，再对这两个小区间求解
     * 横着刷完后，最矮柱子左右分成两个区间，递归。这两个区间再计算横着刷的次数时，应当把下方已经刷过的高度减掉
     *  但是如果计算竖着刷的次数，那么下方被刷过的地方并不影响
     * @param array
     */
    public static void solution(long[] array){
        //有相同的就横着刷，没有就竖着刷
        int len = array.length;
        System.out.println(recur(array,0,len-1,0));
    }

    private static long recur(long[] a, int l, int r, long lastMin){
        if(l == r){
            return 1;
        }
        //当前最小值
        long nowMin = Integer.MAX_VALUE;
        for(int i = l; i<=r; i++){
            nowMin = Math.min(nowMin,a[i]);
        }
        //lastMin上一次的最小值，当前最小值-上一次的最小值，就是这次的公共横刷区域
        long ans = nowMin - lastMin;
        int s = l;
        for(int i = l ; i<= r; i++){
            if(a[i] == nowMin){
                if(i == s){
                    s++;
                }else{
                    //左区间
                    ans += recur(a,s,i-1,nowMin);
                    s = i+1;
                }
            }else{
                if(i == r){
                    ans += recur(a,s,i,nowMin);
                }
            }
        }
        //r-left+1等于竖着刷的次数，返回：全部竖着刷 or 下方横着刷的最小值
        return Math.min(ans,r-l+1);
    }
}
