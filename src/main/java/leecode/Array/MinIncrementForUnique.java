package leecode.Array;

import java.util.Arrays;

public class MinIncrementForUnique {

    public int minIncrementForUnique(int[] A) {
         if(A.length == 0){
             return 0;
         }
        Arrays.sort(A);
        int preNum = A[0];
        int res = 0;
         for(int i = 1; i<A.length ; i++){
             // preNum + 1 表示当前数「最好」是这个值，即前一个值+1
              if(A[i] < preNum+1){
                 res += preNum - A[i] +1;
                 preNum++;
              }else{
                  preNum = A[i];
              }
         }
         return res;
    }
}
