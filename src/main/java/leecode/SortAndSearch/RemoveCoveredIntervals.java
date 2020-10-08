package leecode.SortAndSearch;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    /*
    [leetcode 1288. 删除被覆盖区间](https://leetcode-cn.com/problems/remove-covered-intervals/)
     */
    public int removeCoveredIntervals(int[][] intervals) {
        //按照起始位置升序，按照终止位置降序
        Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;//覆盖的区间的个数
        for(int i = 1; i<intervals.length;i++){
            int[] interval = intervals[i];
            //被覆盖
            if(left<=interval[0] && interval[1]<=right){
               res++;
            }
            //相交,合并区间
            if(left<=interval[0] && interval[1]>=right){
                right = interval[1];
            }
            //不相交，重新定义左右边界
            if(interval[0]>right){
               left = interval[0];
               right = interval[1];
            }
        }
        return intervals.length-res;
    }
}

