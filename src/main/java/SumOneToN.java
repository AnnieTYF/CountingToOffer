public class SumOneToN {
    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
     * @param n
     * @return
     */

    /**
     * 解法一：利用n(n+1)/2公式
     * 也有用快速幂代替Math.pow(n,2)的
     * 17ms
     * @param n
     * @return
     */
    public static int Sum_Solution(int n) {
        return (int)(Math.pow(n,2)+n)>>1;
    }

    /**
     *解法二：递归实现，利用短路求值原理
     * 短路求值原理：&&就是逻辑与，逻辑与有个短路特点，前面为假，后面不计算
     * 当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0
     * 当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)
     *18ms
     */
    public static int Sum_Solution2(int n) {
        int sum = n;
        //必须保证&&两边都是boolean值
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

    /**
     * 解法三：快速幂
     *
     * n(n+1)/2,递归实现n(n+1)；
     * 先参考使用while的例子，再转换
     * 原理是把a拆成2的幂的和，a = 2^e0 + 2^e1 + 2^e2....
     *  那么 a * b = (2^e0 + 2^e1 + 2^e2+...) * b
     *                       = b * 2^e0 + b * 2^e1 + b * 2^e2 + ...
     *                       = (b << e0) + (b << e1) + ....
     * @param n
     * @return
     */
    public static int Sum_Solution3(int n) {
        int res = 0;
        int a = n;//若a=2=10
        int b = n + 1;//b=3=11
        while (a != 0) {
            if ((a & 1) == 1)//a在第二位==1的时候才更新res=0+110=6
                res += b;
            a >>= 1;//a右移1位 1
            b <<= 1;//b左移动1位 110
        }
        return res>>=1;
    }

    public static void main(String args[]){
        System.out.println(Sum_Solution3(10));
    }
}
