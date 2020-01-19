public class RectangleCover {
    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     */
    /**
     * 分析：还是可以归结于斐波那契数列
     * 小矩形板子只有两种可能，竖着 或 横着，而且横着的话必然是两块板子拼成一个2*2的正方形，
     * 那么接下来就简单了
     * ——  一只青蛙每次只能跳1个台阶或两个台阶，要跳上n个台阶有多少种方法？
     */
    public int rectCover(int number)
    {
        if(number == 1){
            return 1;
        }
        if(number == 2){
            return 2;
        }
        int nMinus1 = 2;
        int nMinus2 = 1;
        int cur = 0;
        for(int i = 3; i<=number;i++){
            cur = nMinus1 + nMinus2;
            nMinus2 = nMinus1;
            nMinus1 = cur;
        }
        return cur;
    }
}
