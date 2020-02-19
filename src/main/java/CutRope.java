public class CutRope {
    /**
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为k[0],k[1],...,k[m]。
     * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     */
    /**
     * 解题思路：
     * m=2时，最多分1段，最大乘积为1*1 = 1
     * 3-》2
     * 4-》2*2
     * 5-》2*3
     * 6-》3*3
     * 7 -》 2*2*3 -》4*3
     * 8 -》 2*3*3
     * 所以绳子的最大成绩就是 n个2乘以m个3，3越多越好
     * 所以我们将target%3，剩下的数转化为2的乘积
     * 当n＞3时，有三种情况，即n%3==0, n%3==1, n%3==2
     * 16ms
     */
    /**
     * 贪婪算法：
     * 当n大于等于5时，我们尽可能多的剪长度为3的绳子；
     * 剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。
     * 为什么选2，3为最小的子问题？因为2，3包含于各个问题中，如果再往下剪得话，乘积就会变小。
     * 为什么选长度为3？因为当n≥5时，3(n−3)≥2(n−2)
     * @param target
     * @return
     */
    public static int cutRope(int target) {
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }

        if(target%3 == 0){
            return (int)Math.pow(3,target/3-1);
        }else if(target%3 == 1){
            /*  当最后绳子长度为 4 时，这时候分割成 2，2 而不是 3，1 因为2*2=4 > 3=3*1  */
            return (int)Math.pow(3,target/3-1)* 4;
        }else {
            return (int)Math.pow(3,target/3)* 2;
        }
    }
    public static void main(String args[]){
            System.out.println(cutRope(4));
    }
}
