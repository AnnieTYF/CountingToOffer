package leecode.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class eggDrops {
    /**
     * 假设有 100 层的高楼，给你两个完全一样的鸡蛋。
     * 请你设计一种方法，能够试出来从第几层楼开始往下扔鸡蛋，鸡蛋会碎。
     * 当然，这个问题还有推广版本，有兴趣的同学可以思考一下。
     * 假设有 n 层楼，给你 k 个完全一样的鸡蛋，请问最坏情况下，
     * 至少需要试验多少次才能知道从第几层楼开始往下扔鸡蛋，鸡蛋会碎。
     */

    /**
     * 解法一：动态规划+二分法
     * 很容易想到用动态规划来做这道题，之前也做过这道题。状态可以表示成 (K, N): K 为鸡蛋数和 N 为楼层数。当从第 X
     * 楼扔鸡蛋的时候，要么鸡蛋不碎，状态变成 (K, N-X)，或者碎掉，状态变成 (K-1, X-1)。
     * 动态规划的时间复杂度为 O(KN^2)
     * 但对于这道题其实是不够高效的，可以做的更快。定义 dp(K, N) 为状态 (K, N) 下最多需要的步数。根据以上分析：
     * dp(K,N)=min（max(dp(K−1,X−1),dp(K,N−X))) 1≤X≤N
     * 这里需要注意的是，dp(K,N) 是一个关于 N 的递增函数。在最大式中，第一项T1=dp(K−1,X−1) 是一个随 X 递增的函数，
     * 第二项 T2=dp(K,N−X) 也是一个随着 X 递减的方法。这种情况下是可以用二分搜索去找 X的。
     * 算法
     * 对于一个 X，如果 T1<T2 意味着 X太小了；
     * 如果T1>T2，意味着 X太大了。
     * 时间复杂度：O(K∗NlogN)。
     * 空间复杂度：O(K∗N)
     */
    public int superEggDrop(int K, int N) {
        return dp(K,N);
    }
    Map<Integer,Integer> memo = new HashMap<>();
    public int dp(int K, int N){
        if(!memo.containsKey(N*100 + K)){
            int ans;
            if(N == 0){
                ans=0;
            }else if(K==1){
                ans = N;
            }else{
                int low = 1;
                int high = N;
                while(low + 1 < high){
                    int x = (low+high)/2;
                    //鸡蛋碎了
                    int t1 = dp(K-1, x-1);
                    //鸡蛋没碎
                    int t2 = dp(K,N-x);
                    if(t1<t2){
                        low = x;
                    }else if(t1>t2){
                        high = x;
                    }else{
                        low = high = x;
                    }
                }
                ans = 1 + Math.min(Math.max(dp(K-1, low-1), dp(K, N-low)),
                        Math.max(dp(K-1, high-1), dp(K, N-high)));

            }
            memo.put(N * 100 + K, ans);
        }
        return memo.get(N * 100 + K);
    }

    /**
     * 解法二：基于最优策略的动态规划
     * 自底向上的动态规划
     * 时间复杂度： O(K∗N)。
     * 空间复杂度： O(N)
     */
    public int superEggDrop2(int K, int N) {
        // Right now, dp[i] represents dp(1, i)
        int[] dp = new int[N+1];
        for (int i = 0; i <= N; ++i) {
            dp[i] = i;
        }
        for (int k = 2; k <= K; ++k) {
            // Now, we will develop dp2[i] = dp(k, i)
            int[] dp2 = new int[N+1];
            int x = 1;
            for (int n = 1; n <= N; ++n) {
                // Let's find dp2[n] = dp(k, n)
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[n-x]) > max(dp[x], dp2[n-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                while (x < n && Math.max(dp[x-1], dp2[n-x]) > Math.max(dp[x], dp2[n-x-1])) {
                    x++;
                }
                // The final answer happens at this x.
                dp2[n] = 1 + Math.max(dp[x-1], dp2[n-x]);
            }
            dp = dp2;
        }
        return dp[N];
    }

    /**
     * 解法三：数学法
     *是一个很NB的算法，具体是什么没看懂
     */
    public int superEggDrop3(int K, int N) {
        int lo = 1, hi = N;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (f(mi, K, N) < N) {
                lo = mi + 1;
            }
            else {
                hi = mi;
            }
        }

        return lo;
    }

    public int f(int x, int K, int N) {
        int ans = 0, r = 1;
        for (int i = 1; i <= K; ++i) {
            r *= x-i+1;
            r /= i;
            ans += r;
            if (ans >= N) break;
        }
        return ans;
    }


}
