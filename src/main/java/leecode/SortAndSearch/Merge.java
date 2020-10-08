package leecode.SortAndSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
[leetcode 56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/)
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];
        }
        //按照起始位置升序
        Arrays.sort(intervals,(a, b)->{
            return a[0]-b[0];
        });
        //覆盖的区间的个数，注意这种二维数组的处理
        List<int[]> res =  new ArrayList<int[]>();
        res.add(intervals[0]);
        for(int i = 1; i<intervals.length;i++){
            int[] interval = intervals[i];
            int left = interval[0];
            //之前区间的右边< 现在区间的左边
            if(res.get(res.size()-1)[1]< left|| res.size() == 0){
                //不相交，重新定义左右边界
                res.add(interval);
            }else{
                //相交,合并区间,更新最近一次区间的范围
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],interval[1]);
            }
        }
        //list转换成二维数组
        return res.toArray((new int[res.size()][]));
    }
}
