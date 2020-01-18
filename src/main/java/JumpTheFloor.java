public class JumpTheFloor {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */
    /**
     * 解题思路：这个跳台阶问题本质是斐波那契数列
     * 假设一共有n阶楼梯：青蛙跳一阶楼梯的数量等于f(n-1)，青蛙跳2阶楼梯的数量是f(n-2_
     * f(n) = f(n-1)+f(n-2)
     * 当第一次跳一阶时 f(1) = 1
     * 当第一次跳两阶时f(2) = 2
     * @param number
     * @return
     */
    public int jumpFloor(int number)
    {
        if(number == 1){
            return 1;
        }
        if(number == 2){
            return 2;
        }
        int pre = 2;
        int prePre = 1;
        int current = 0;
        for(int i=3; i <= number ; i++){
            current = pre + prePre;
            prePre = pre;
            pre = current;
        }
        return current;
    }
}
