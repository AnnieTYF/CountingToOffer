public class CalculationForPower {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。
     * 求base的exponent次方。
     * 保证base和exponent不同时为0
     */
    public static void main(String args[]){
                System.out.println("count: "+Power3(3.0,-2));
    }

    public static double Power(double base, int exponent) {
        return Math.pow(base,exponent);
    }

    /**
     * 解法一：快速幂
     * 时间复杂度 O(logN)
     * @param base
     * @param exponent
     * @return
     */
    public static double Power2(double base, int exponent) {
        double ans = 1;
        if(exponent == 0){
            return 1;
        }
        if(base == 0){
            return 0;
        }
        int e  = exponent>0 ? exponent:-exponent;
        while (e != 0) {
            if ((e & 1) != 0) { //如果当前的次幂数最后一位(二进制数)不为0的话，那么我们将当前权值加入到最后答案里面去
                ans = ans * base;
            }
            //权值增加
            base = base * base;
            e >>= 1;
        }
        return exponent>0 ?ans:1/ans;
    }

    /**
     * 解法三：递归
     * 当n为偶数，a^n =（a^n/2）*（a^n/2）
     * 当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a
     * @param base
     * @param exponent
     * @return
     */
    public static double Power3(double base, int exponent) {
        double ans = 0.0;
        if(exponent == 0){
            return 1;
        }
        if(base == 0){
            return 0;
        }
        int e  = exponent>0 ? exponent:-exponent;
        ans = Power3(base, e >> 1);
        //n无论奇偶都有这一步
        ans *= ans;
        //如果n为奇数，再乘以base
        if((e & 1 )== 1){
            ans *= base;
        }
        return exponent>0 ?ans:1/ans;
    }
}
