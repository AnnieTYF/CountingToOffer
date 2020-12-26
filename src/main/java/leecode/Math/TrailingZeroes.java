package leecode.Math;

public class TrailingZeroes {

    public int preimageSizeFZF(int K) {
        // 左边界和右边界之差 + 1 就是答案
        return (int)rightRound(K) - (int)leftRound(K) + 1;
    }
    public long trailingZeroes(long n){
        long  res = 0; // 逻辑不变，数据类型全部改成 long
        for(long d = n; d/5 >0 ; d=d/5){
            res += d/5;
        }
        return res;
    }
    /* 搜索 trailingZeroes(n) == K 的右侧边界 */
    public long rightRound(int target){
        long low = 0;
        long high = Long.MAX_VALUE;
        while(low <= high){
            long mid = low + (high-low)/2;
            if(trailingZeroes(mid) == target){
                low = mid + 1;
            }else if(trailingZeroes(mid) < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return high;
    }
    //搜索 trailingZeroes(n) == K 的左侧边界
    public long leftRound(int target){
        long low = 0;
        long high = Long.MAX_VALUE;
        while(low <= high){
            long mid = low + (high-low)/2;
            if(trailingZeroes(mid) == target){
                high = mid-1;
            }else if(trailingZeroes(mid) < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }
}
