package leecode.SortAndSearch;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        //两个指针分别指向A,B
         int i = 0;
         int j = 0;
         List<int[]> res =  new ArrayList<int[]>();
         while(i<A.length && j<B.length){
             int[] a = A[i];
             int[] b = B[j];
             int left = Math.max(a[0],b[0]);
             int right = Math.min(a[1],b[1]);
             //是否存在交集
             if(left <= right){
                 res.add(new int[]{left,right});
             }
             if(a[1]<b[1]){
                 i++;
             }else{
                 j++;
             }
         }
        //list转换成二维数组
        return res.toArray((new int[res.size()][]));
    }
}
