package Autumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TESTTX {

   public static int[][] merge(int[][] array){
       //按照起始位置排序
       Arrays.sort(array,(a,b)->{
           return a[0] - b[0];
       });
       List<int[]> res = new ArrayList<int[]>();
       res.add(array[0]);
       for(int i = 1; i<array.length ; i++){
           int[] temp = array[i];
           int left = temp[0];
           //如果区间的右边 < 区间的左边
           if(res.get(res.size()-1)[1] < left || res.size() == 0){
               //不相交，重新定义左右边界
               res.add(temp);
           }else{
               //相交，合并区间
               res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],temp[1]);
           }
       }
       return res.toArray(new int[res.size()][]);
   }
   public static void main(String[] args){
       int[][] array = {{1,3},{4,7},{6,9}};
       int[][] res = merge(array);
       for(int i = 0; i< res.length ; i++){
           System.out.println("[" + res[i][0] + ","+res[i][1] + "]");
       }
   }
}
