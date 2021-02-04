package leecode.Array;

import java.util.Stack;

public class ReverseInteger {
    public int reverse(int x) {
       int ans = 0;
       while(x != 0){
           int pop = x % 10; //从后往前取出单个数值
           if(ans > Integer.MAX_VALUE/10 || (ans < Integer.MAX_VALUE && pop > 7)){
               return 0;
           }
           if(ans < Integer.MIN_VALUE/10 || (ans > Integer.MIN_VALUE/10 && pop > 8)){
               return 0;
           }
           ans = ans * 10 + pop;
       }
       return ans;
    }
}
